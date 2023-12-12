package com.legendaryrealms.LegendaryGuild.Hook.Attribute;

import com.legendaryrealms.LegendaryGuild.Data.Others.Buff;
import com.legendaryrealms.LegendaryGuild.LegendaryGuild;
import com.legendaryrealms.LegendaryGuild.Manager.Others.BuffsManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public abstract class AttributePluginProvider {
    public abstract void updataBuff(Player p);
    public static boolean HookPlugin(AttributePlugin plugin, BuffsManager manager){
        switch (plugin){
            case AP2: {
                if (hasPlugin("AttributePlus")){

                    LegendaryGuild.getInstance().info("已关联插件 AttributePlus.", Level.INFO);
                    return true;
                }
                LegendaryGuild.getInstance().info("未发现插件 AttributePlus 已关闭Buff功能.", Level.SEVERE);
                return false;
            }
            case AP3: {
                if (hasPlugin("AttributePlus")){
                    manager.hook(new AttributePlus3());
                    LegendaryGuild.getInstance().info("已关联插件 AttributePlus .", Level.INFO);
                    return true;
                }
                LegendaryGuild.getInstance().info("未发现插件 AttributePlus 已关闭Buff功能.", Level.SEVERE);
                return false;
            }
            case SX2: {
                if (hasPlugin("SX-Attribute")){

                    LegendaryGuild.getInstance().info("已关联插件 SX-Attribute .", Level.INFO);
                    return true;
                }
                LegendaryGuild.getInstance().info("未发现插件 SX-Attribute 已关闭Buff功能.", Level.SEVERE);
                return false;
            }
            case MythicLib: {
                if (hasPlugin("MythicLib")){

                    LegendaryGuild.getInstance().info("已关联插件 MythicLib .", Level.INFO);
                    return true;
                }
                LegendaryGuild.getInstance().info("未发现插件 MythicLib 已关闭Buff功能.", Level.SEVERE);
                return false;
            }
            default: return false;
        }

    }
    private static boolean hasPlugin(String name){
        return Bukkit.getPluginManager().isPluginEnabled(name);
    }
    public enum AttributePlugin {
        AP3,
        AP2,
        SX2,
        MythicLib;
    }
}
