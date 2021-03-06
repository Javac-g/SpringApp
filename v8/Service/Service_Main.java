package com.MAX.v8.Service;

import com.MAX.v8.Controller.RequestDTO;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service_Main {

    private List<ResponseDTO> datalist = new ArrayList<>();

    public String print(String msg){
        return msg;
    }
    public void log(String type,ResponseDTO user){

        byte[] data = ("\nType: " + type + "\nName: " + user.getName()+ "\nId: " + user.getId()).getBytes();
        String A = "\nTool - A: "+ user.getTool().getFirst() + "\nTool - A: " + user.getTool().getSecond();
        String B = "\nCar: " + user.getCarEnum();

        try(FileOutputStream fileOutputStream = new FileOutputStream("Logger.dat",true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)){


            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);

            dataOutputStream.writeUTF(A);
            dataOutputStream.writeUTF(B);


        }catch (IOException e){
            e.printStackTrace();
        }



    }
    public ResponseDTO Create(RequestDTO data){
        ResponseDTO user = new ResponseDTO();

        user.setName(data.getName());
        user.setId(data.getId());
        user.setTool(data.getTool());
        user.setEnum(user,data);
        log("Created",user);
        datalist.add(user);
        return user;

    }
    public ResponseDTO Read(Integer id){
        for (ResponseDTO user: datalist){
            if (user.getId().equals(id)){
                log("Searched",user);
                return user;
            }
        }
        return null;
    }
    public ResponseDTO update(Integer id, RequestDTO data){
        ResponseDTO user = Read(id);
        if (user != null){
            user.setName(data.getName());
            user.setId(data.getId());
            user.setTool(data.getTool());
            user.setEnum(user,data);
            return user;
        }
        return null;
    }
    public Integer deleteA(Integer id){
        int x = -1;
        for (int i = 0;i < datalist.size();i++){
            if (datalist.get(i).getId().equals(id)){
                x = i;
                log("Deleted",datalist.get(x));
            }
        }
        if (x != -1){
            datalist.remove(x);
            return x;
        }
        return null;
    }
    public Integer deleteB(Integer id){
        int x = -1;
        for (ResponseDTO user:datalist){
            if (user.getId().equals(id)){
                x = datalist.indexOf(user);
                datalist.remove(user);
                return x;
            }
        }
        return null;
    }
}
