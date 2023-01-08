package com.javatest.SpringbootTest.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.javatest.SpringbootTest.models.Arrays;
import com.javatest.SpringbootTest.models.DateConvert;
import com.javatest.SpringbootTest.models.Supply;
import com.javatest.SpringbootTest.models.Demand;
import com.javatest.SpringbootTest.models.Inventory;
import com.javatest.SpringbootTest.models.Calendar;

@RestController
public class Controller {

    Arrays arrays = new Arrays();

    @RequestMapping(value = "supply")
    public Supply prueba() {
        return arrays.getSupplies().get(0);
    }

    @GetMapping(value = "getAvailability")
    public String getAvailability(String productId) {
        Supply supply = arrays.getSupplies().stream().filter(p->p.getProductId().equals(productId)).toList().get(0);
        Demand demand = arrays.getDemands().stream().filter(p->p.getProductId().equals(productId)).toList().get(0);
        /*for (Supply sup : arrays.getSupplies()) {
            if (productId.equals(sup.getProductId())) {
                supply = sup;
            }
        }*/

        /*for (Demand dem : arrays.getDemands()) {
            if (productId.equals(dem.getProductId())) {
                demand = dem;
            }
        }
        */
        double availability = supply.getQuantity() - demand.getQuantity();
        if (availability > 0) {
            return "{\"productId\":\"" + productId + "\",\"Availability\":" + availability + ",}";
        } else {
            return "204 No Content";
        }
    }

    @GetMapping(value = "getInvPicture")
    public String getInvPicture(String productId, String prodName, String reqDate) {
        Date date = DateConvert.Format("yyyy-MM-dd",reqDate);

        Date dateFuture = DateConvert.addDaysToDate(date);

        if (date.before(arrays.getInventories().get(0).getAvailDate()) ||
                date.after(arrays.getInventories().get(arrays.getInventories().size() - 1).getAvailDate())) {

            return "Bad request - 400";
        }
        double sum= arrays.getInventories().stream().filter(inventory -> inventory.getProductid().equals(productId) &&
                inventory.getProdName().equals(prodName) &&
                !inventory.getAvailDate().before(date) &&
                !inventory.getAvailDate().after(dateFuture)).mapToDouble(inv->inv.getAvailQty()).sum();



        /*for (Inventory inventory : arrays.getInventories()) {
            if (inventory.getProductid().equals(productId) &&
                    inventory.getProdName().equals(prodName) &&
                    !inventory.getAvailDate().before(date) &&
                    !inventory.getAvailDate().after(dateFuture)) {
                sum += inventory.getAvailQty();
            }
        }*/

        return "{\"productId\":\"" + productId + "\",\"prodName\":\"" + prodName + "\", \"availQty\": " + sum + "}";
    }

    @PostMapping(value = "findStoreAvailability")
    public String findStoreAvailability(String storeID, String requestDate) {
        String message = "Not Available";
        /*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Date date = new Date();
        try {
            date = format.parse(requestDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        Date date = DateConvert.Format("yyyy-MM-dd'T'HH:mm:ss.SSS",requestDate);
        String dayString = arrays.getDayString(DateConvert.getDayOfWeek(date));

        if(arrays.getCalendars().stream().filter(calendar -> {
           return calendar.getLocationID().equals(storeID) &&
                    calendar.IsAvailable(dayString,DateConvert.getHourOfDay(date),DateConvert.getMinutesOfDay(date));
        }).count()>0){
         message="AVAILABLE";
        }

        /*for (Calendar calen : arrays.getCalendars()) {
            if (storeID.equals(calen.getLocationID())) {
                if (calen.getDay().equals("ALL")) {
                    System.out.println(DateConvert.getHourOfDay(date) + "<=" + calen.getCutOffTime().getHour());
                    System.out.println(DateConvert.getMinutesOfDay(date) + "<" + calen.getCutOffTime().getMinute());
                    if (DateConvert.getMinutes(DateConvert.getHourOfDay(date),
                            DateConvert.getMinutesOfDay(date)) < DateConvert.getMinutes(calen.getCutOffTime().getHour(),
                                    calen.getCutOffTime().getMinute())) {
                        message = "AVAILABLE";
                    }
                } else {
                    if (calen.getDay().equals(dayString)) {
                        if (DateConvert.getMinutes(DateConvert.getHourOfDay(date),
                                DateConvert.getMinutesOfDay(date)) < DateConvert.getMinutes(
                                        calen.getCutOffTime().getHour(),
                                        calen.getCutOffTime().getMinute())) {
                            message = "AVAILABLE";
                        }
                    }
                }
            }
        }*/
        return "{\"storeID\":" + storeID + ",\"requestDate\":\"" + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(date)+"Z" + "\",\"status\":\"" + message
                + "\"}";

    }
}
