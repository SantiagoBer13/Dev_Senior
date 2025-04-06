package com.code;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class AnalisisFacturasEmpresa {
    private List<Bill> bills;
    
    public AnalisisFacturasEmpresa(List<String> bills) {
        this.bills = bills.stream().map(e -> {
            String[] datos = e.split(",");
            return new Bill(
                datos[0],
                datos[1],
                Double.parseDouble(datos[2]),
                Double.parseDouble(datos[3])
            );
        }).collect(Collectors.toList());
    }

    public Map<String, Double> getAmountWithIva(){
        return this.bills.stream()
                .collect(Collectors.toMap(Bill::getIdBill, Bill::getTotal, (a, b) -> a + b));
    }

    public Map<String, Double> getTotalByCustomer(){
        return this.bills.stream()
                .collect(Collectors.groupingBy(Bill::getCustomer, Collectors.summingDouble(Bill::getTotal)));
    }

    public List<Bill> filterBillsHigher(Double amount){
        return this.bills.stream()
                .filter(b -> b.getAmount() > amount)
                .collect(Collectors.toList());
    }

    public String  getCustomerWithIncomeHigher(){
        return this.bills.stream()
                .collect(Collectors.groupingBy(Bill::getCustomer, Collectors.summingDouble(Bill::getTotal)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public class Bill{
        private String idBill;
        private String customer;
        private Double amount;
        private Double iva;
        public Bill(String idBill, String customer, Double amount, Double iva) {
            this.idBill = idBill;
            this.customer = customer;
            this.amount = amount;
            this.iva = iva;
        }
        public String getIdBill() {
            return idBill;
        }
        public String getCustomer() {
            return customer;
        }
        public Double getAmount() {
            return amount;
        }
        public Double getIva() {
            return iva;
        }
        public Double getTotal(){
            return amount + (amount * iva / 100);
        }
    }
}
