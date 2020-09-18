package controller;

import adapter.ProductAdapter;
import model.mdlBarang;
import model.mdlProduct;
import model.mdlResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.net.InetAddress;
import java.util.Date;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping(value = "/get-product-depan-list", method = RequestMethod.GET)
    public @ResponseBody
    mdlResult GetProductDepan(){
        mdlResult _mdlResult = new mdlResult();
        List<mdlProduct> _mdlProductList = new ArrayList<>();

        _mdlProductList = ProductAdapter.GetProductListDepan();

        if(_mdlProductList != null){
            _mdlResult.statusCode = "ERR-00-000";
            _mdlResult.statusText = "Success";
            _mdlResult.statusInfo = "Data berhasil";
            _mdlResult.value = _mdlProductList;
        }else {
            _mdlResult.statusCode = "ERR-00-001";
            _mdlResult.statusText = "Success";
            _mdlResult.statusInfo = "Data kosong";
            _mdlResult.value = null;
        }


        return  _mdlResult;
    }

    @RequestMapping(value = "/get-barang-list", method = RequestMethod.GET)
    public @ResponseBody
    mdlResult GetBarang(){
        mdlResult _mdlResult = new mdlResult();
        List<mdlBarang> _mdlBarangList = new ArrayList<>();

        _mdlBarangList = ProductAdapter.GetBarangList();

        if(_mdlBarangList != null){
            _mdlResult.statusCode = "ERR-00-000";
            _mdlResult.statusText = "Success";
            _mdlResult.statusInfo = "Data berhasil";
            _mdlResult.value = _mdlBarangList;
        }else {
            _mdlResult.statusCode = "ERR-00-001";
            _mdlResult.statusText = "Success";
            _mdlResult.statusInfo = "Data kosong";
            _mdlResult.value = null;
        }

        return  _mdlResult;
    }

    @RequestMapping(value = "/get-date", method = RequestMethod.GET)
    public @ResponseBody
    mdlResult GetDate(){
        mdlResult _mdlResult = new mdlResult();

        //getting current date and time using Date class
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss.SSS");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        String timeServer = df.format(dateobj);

        /*getting current date time using calendar class
         * An Alternative of above*/
        Calendar calobj = Calendar.getInstance();
        System.out.println(df.format(calobj.getTime()));

        _mdlResult.statusCode = "ERR-00-000";
        _mdlResult.statusText = "Success";
        _mdlResult.statusInfo = "Data berhasil";
        _mdlResult.value = timeServer;



        return  _mdlResult;
    }

    @RequestMapping(value = "/get-time", method = RequestMethod.GET)
    public @ResponseBody
    mdlResult GetTimeServer() throws IOException {
        mdlResult _mdlResult = new mdlResult();

        String TIME_SERVER = "pool.ntp.org";
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
        TimeInfo timeInfo = timeClient.getTime(inetAddress);
        long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
        Date time = new Date(returnTime);
        System.out.println("Time from " + TIME_SERVER + ": " + time);

        _mdlResult.statusCode = "ERR-00-000";
        _mdlResult.statusText = "Success";
        _mdlResult.statusInfo = "Data berhasil";
        _mdlResult.value = time;



        return  _mdlResult;
    }

    @RequestMapping(value = "/get-time-zone", method = RequestMethod.GET)
    public @ResponseBody
    mdlResult GetTimeZoneServer() throws IOException {
        mdlResult _mdlResult = new mdlResult();

        //get Calendar instance
        Calendar calendar = new GregorianCalendar();
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Copenhagen");
        calendar.setTimeZone(timeZone);

        //get current TimeZone using getTimeZone method of Calendar class

        //display current TimeZone using getDisplayName() method of TimeZone class
        System.out.println("Current TimeZone is : " +  TimeZone.getTimeZone("Etc/GMT+0"));

        _mdlResult.statusCode = "ERR-00-000";
        _mdlResult.statusText = "Success";
        _mdlResult.statusInfo = "Data berhasil";
        _mdlResult.value =  TimeZone.getTimeZone("Etc/GMT+0");



        return  _mdlResult;
    }
}
