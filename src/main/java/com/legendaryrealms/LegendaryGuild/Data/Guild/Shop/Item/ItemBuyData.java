package com.legendaryrealms.LegendaryGuild.Data.Guild.Shop.Item;

import com.legendaryrealms.LegendaryGuild.Data.Guild.Shop.Item.BuyAmount;
import com.legendaryrealms.LegendaryGuild.Data.Guild.Shop.Item.ShopType;

import java.util.HashMap;
import java.util.Map;

public class ItemBuyData {

    private String id;
    private HashMap<String, BuyAmount> data;

    public ItemBuyData(String id, HashMap<String, BuyAmount> data) {
        this.id = id;
        this.data = data;
    }

    public int getBuyAmount(String player, ShopType type) {
        BuyAmount amount = data.containsKey(player) ? data.get(player) : new BuyAmount(player, new HashMap<>());
        return amount.getAmount(type);
    }

    public void addBuyAmount(String player, ShopType type, int amount) {
        BuyAmount buyAmount = data.containsKey(player) ? data.get(player) : new BuyAmount(player, new HashMap<>());
        buyAmount.addAmount(type, amount);
        data.put(player, buyAmount);
    }

    public void setBuyAmount(String player, ShopType type, int amount) {
        BuyAmount buyAmount = data.containsKey(player) ? data.get(player) : new BuyAmount(player, new HashMap<>());
        buyAmount.setAmount(type, amount);
        data.put(player, buyAmount);
    }

    public String getId() {
        return id;
    }

    //item1⁝ (p1:0;p2:0⁞)
    // item1⁝p1:0;p2:0⁞item1⁝p1:0;p2:0⁞
    public String toString(ShopType type){
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, BuyAmount> entry:data.entrySet()){
            builder.append(id).append("⁝").append(entry.getValue().toString(type)).append("⁞");
        }
        return builder.toString();
    }

}
