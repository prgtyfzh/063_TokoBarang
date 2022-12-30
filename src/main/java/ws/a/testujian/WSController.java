/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.testujian;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */

@Controller
@ResponseBody
public class WSController {
    
    Barang data = new Barang();
    BarangJpaController actrl = new BarangJpaController();
    
    @RequestMapping("/getPro")
    public List<Barang> getData(){
        
        return actrl.findBarangEntities();
        
    }
    
    @RequestMapping ("/getProduct/{id}")
    public String getData(@PathVariable("id") int id){
        try {
            data = actrl.findBarang(id);
                    return "Nama Barang : " + data.getNama()+ "<br>" + "Jumlah Barang : " + data.getJumlah();
        }
        catch (Exception error){return "ID NOT FOUND";}
    }
    
    @RequestMapping("/delete/{id}")
    public String delData(@PathVariable("id") int id){
        try{
            actrl.destroy(id);
            return id + "Deleted";
        }
        catch (Exception error){return id + " " + "ID NOT FOUND";}
    }
    
}
