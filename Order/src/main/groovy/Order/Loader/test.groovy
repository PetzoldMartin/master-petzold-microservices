package Order.Loader

import Order.Entities.Account
import Order.Entities.Item
import Order.Entities.ItemSet
import Order.Entities.OrderConcepts.Favorite
import Order.Entities.OrderConcepts.Order
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.lang.time.DateUtils
import org.yaml.snakeyaml.Yaml
Item i1=new Item(name: "Pizza Margherita",details: "Die standard Pizza",allergens: false,currency: new BigDecimal("1.20"))
Item i2=new Item(name: "Hamburger",details: "Ein Burger ohne Käse",allergens: true,currency: new BigDecimal("2.01"))
Item i3=new Item(name: "Hamburger Big",details: "Ein Großer Burger mit Käse",allergens: true,currency: new BigDecimal("5.01"))

Order o=new Order(date:new Date())
Order o2=new Order(date:DateUtils.addHours(new Date(),-1))
Order o3=new Order(date:DateUtils.addHours(new Date(),-2))

Favorite f=new Favorite(count: 5,name: "Monday")
Favorite f2=new Favorite(count: 5,name: "Friday")

ItemSet is1=new ItemSet(orderConcept: o,item: i1)
ItemSet is2=new ItemSet(orderConcept: o,item: i2,count: 2)
ItemSet is3=new ItemSet(orderConcept: f,item: i1,count: 2)
ItemSet is4=new ItemSet(orderConcept: f,item: i2)
Account a=new  Account(name: "First",mail: "aismaelinc@gmail.com")
Account a2=new  Account(name: "Second",mail: "aismaelinc@web.de")
Account a3=new  Account(name: "Third",mail: "test@west@gmail.com")

//wire
a.getOrders().add(o)
a.getOrders().add(o2)
a2.getOrders().add(o3)

a.getFavorites().add(f)
a.getFavorites().add(f2)
i1.getItemSets().add(is1)
i1.getItemSets().add(is3)
i2.getItemSets().add(is2)
i2.getItemSets().add(is4)
o.getItemSets().add(is1)
o.getItemSets().add(is2)
f.getItemSets().add(is3)
f.getItemSets().add(is4)

ObjectMapper mapper = new ObjectMapper();
try {
    println mapper.writeValueAsString(o);
}catch (JsonProcessingException e){
    e.printStackTrace();
    println "error";
}