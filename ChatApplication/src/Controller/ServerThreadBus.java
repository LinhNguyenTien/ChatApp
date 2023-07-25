/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Server;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 * Class ServerThreadBus executes all features that users can in the software
 */
public class ServerThreadBus {
    private List<ServerThread> listServerThreads;
    //Constructor
    public ServerThreadBus() {
        listServerThreads = new ArrayList<>();
    }
    
    //Lấy danh sách các luồng đang chạy
    public List<ServerThread> getListServerThreads() {
        return listServerThreads;
    }
    
    //Hàm thêm 1 luồng vào danh sách listServerThreads
    public void add(ServerThread serverThread){
        listServerThreads.add(serverThread);
    }
    
    //In danh sách người dùng đang online ra màn hình
    public void mutilCastSend(String message){ //like sockets.emit in socket.io
        for(ServerThread serverThread : Server.serverThreadBus.getListServerThreads()){
            try {
                serverThread.write(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void boardCast(int id, String message){
        for(ServerThread serverThread : Server.serverThreadBus.getListServerThreads()){
            if (serverThread.getClientNumber() == id) {
                continue;
            } else {
                try {
                    serverThread.write(message);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public int getLength(){
        return listServerThreads.size();
    }   
    
    //Hàm ghi tên tất cả người dùng đang online ra màn hình
    public void sendOnlineList(){
        String res = "";
        List<ServerThread> threadbus = Server.serverThreadBus.getListServerThreads();
        for(ServerThread serverThread : threadbus){
            res+=serverThread.getClientNumber()+"-";
        }
        //Gửi danh sách tên người dùng đang online
        Server.serverThreadBus.mutilCastSend("update-online-list"+","+res);
    }
    
    //Hàm gửi tin nhắn đến 1 người cụ thể
    public void sendMessageToPerson(int id, String message){
        for(ServerThread serverThread : Server.serverThreadBus.getListServerThreads()){
            if(serverThread.getClientNumber()==id){
                try {
                    serverThread.write("global-message"+","+message);
                    break;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    //Hàm xóa 1 luồng ra khỏi danh sách các luồng đang chạy <=> xóa user
    public void remove(int id){
        for(int i=0; i<Server.serverThreadBus.getLength(); i++){
            if(Server.serverThreadBus.getListServerThreads().get(i).getClientNumber()==id){
                Server.serverThreadBus.listServerThreads.remove(i);
            }
        }
    }
}
