package com.legendaryrealms.LegendaryGuild.Manager.Guild;

import com.legendaryrealms.LegendaryGuild.Data.Guild.GuildActivityData;
import com.legendaryrealms.LegendaryGuild.Data.Others.StringStore;
import com.legendaryrealms.LegendaryGuild.LegendaryGuild;

import java.util.HashMap;
import java.util.logging.Level;

public class GuildActivityDataManager {
    private HashMap<String, GuildActivityData> cache;
    private LegendaryGuild legendaryGuild;

    public GuildActivityDataManager(LegendaryGuild legendaryGuild) {
        this.legendaryGuild = legendaryGuild;
        this.cache = new HashMap<>();
    }

    public void removeAll(){
        cache = new HashMap<>();
    }
    public GuildActivityData getData(String guild){
        if (cache.containsKey(guild)){
            return cache.get(guild);
        }
        GuildActivityData data = legendaryGuild.getDataBase().getGuildActivityData(guild).orElse(new GuildActivityData(guild));
        cache.put(guild,data);
        return data;
    }

    public void reloadGuildIfCached(String guild){
        if (cache.containsKey(guild)) {
            cache.put(guild, legendaryGuild.getDataBase().getGuildActivityData(guild).orElse(new GuildActivityData(guild)));
        }
    }
    public void updataGuildActivityData(GuildActivityData data,boolean removeCache){
        legendaryGuild.getDataBase().saveGuildActivityData(data);

        if (removeCache){
            cache.remove(data.getGuild());
            return;
        }
        cache.put(data.getGuild(),data);
    }


    public void checkCycle(){
        int targetInt = legendaryGuild.getFileManager().getConfig().ACTIVITY_CYCLE;
        if (targetInt > 0) {
            int value = Integer.parseInt(legendaryGuild.getDataBase().getSystemData("activity_day").orElse("0"));
            int set = value + 1;
            if (value >= (targetInt - 1)) {
                set = 0;
                legendaryGuild.info("刷新所有公会活跃度", Level.INFO);
                legendaryGuild.info("Refresh all guild activity levels", Level.INFO);
                resetAllGuild();
            }
            legendaryGuild.getDataBase().saveSystemData("activity_day", set + "");
        }
    }

    private void resetAllGuild(){
        legendaryGuild.sync(new Runnable() {
            @Override
            public void run() {
                for (String guild : legendaryGuild.getDataBase().getGuildActivityDatas()){
                    GuildActivityData data = getData(guild);
                    data.setPoints(0);
                    data.setCurrent(new HashMap<>());
                    data.setClaimed(new StringStore());
                    data.update();
                }
            }
        });

    }
}
