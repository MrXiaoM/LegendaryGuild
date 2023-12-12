package com.legendaryrealms.LegendaryGuild.Menu.Panels;

import com.legendaryrealms.LegendaryGuild.API.UserAPI;
import com.legendaryrealms.LegendaryGuild.Data.Guild.Guild;
import com.legendaryrealms.LegendaryGuild.LegendaryGuild;
import com.legendaryrealms.LegendaryGuild.Menu.Loaders.GuildListLoader;
import com.legendaryrealms.LegendaryGuild.Menu.MenuDraw;
import com.legendaryrealms.LegendaryGuild.Menu.MenuItem;
import com.legendaryrealms.LegendaryGuild.Data.User.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;
import java.util.stream.Collectors;

public class GuildListPanel extends MenuDraw {
    private final LegendaryGuild legendaryGuild=LegendaryGuild.getInstance();
    private GuildListLoader loader;
    private int page;
    private Sort sort;
    private HashMap<Integer,Guild> slotToGuild;
    public GuildListPanel(Player p, int page, Sort sort) {
        super(p, "GuildList");
        loader = (GuildListLoader) getLoader();

        this.slotToGuild = new HashMap<>();
        this.page = page;
        this.sort = sort;
        this.inv = Bukkit.createInventory(this,loader.getSize(),legendaryGuild.color(loader.getTitle().replace("%sort%",getPlaceHolder(sort.getPlaceholder()))));

        DrawEssentailSpecial(inv, menuItem -> {
            if (menuItem.getFuction().equals("sort")){
                ItemStack i = menuItem.getI();
                ItemMeta id = i.getItemMeta();
                List<String> lore = id.hasLore() ? new ArrayList<>(id.getLore()) : new ArrayList<>();
                lore.replaceAll(l -> l.replace("%placeholder_sort%",getPlaceHolder(sort.getPlaceholder())));
                id.setLore(lore);
                i.setItemMeta(id);
            }
        });

    }

    @Override
    public void onDrag(InventoryDragEvent e) {

    }

    public List<Guild> getPage(int page){
        List<Integer> layout = getLayout();
        int a = 0;
        int start = 0 + (page-1) * layout.size();
        int end = layout.size() + (page-1)*layout.size();

        List<Guild> returnList = new ArrayList<>();
        List<Guild> guilds = getGuildsBy(sort);
        for (int get = start;get <= end;get++) {
            if (guilds.size() <= get) {
                break;
            }
            returnList.add(guilds.get(get));
        }
        return returnList;
    }

    public void loadGuilds(int page){

        legendaryGuild.sync(new Runnable() {
            @Override
            public void run() {
                List<Integer> layout = getLayout();
                int a = 0;
                for (Guild guild : getPage(page)) {
                    String guildName = guild.getGuild();
                    ItemStack i = new ItemStack(loader.getGuild_icon(),1,(short) loader.getGuild_data());
                    ItemMeta id = i.getItemMeta();
                    id.setDisplayName(loader.getGuild_display().replace("%guild%", guildName));
                    List<String> lore = new ArrayList<>(loader.getGuild_lore());
                    lore.replaceAll(l -> l
                            .replace("%date%", guild.getDate())
                            .replace("%owner%", guild.getOwner())
                            .replace("%level%", "" + guild.getLevel())
                            .replace("%exp%", "" + guild.getExp())
                            .replace("%exp_next%", + legendaryGuild.getFileManager().getConfig().EXP.get(guild.getLevel())+"")
                            .replace("%money%", "" + guild.getMoney())
                            .replace("%members%", "" + guild.getMembers().size())
                            .replace("%maxmembers%", "" + legendaryGuild.getFileManager().getConfig().MEMBERS.get(guild.getLevel()))
                            .replace("%treelevel%", "" + guild.getTreelevel())
                            .replace("%treeexp%", "" + guild.getTreeexp())
                            .replace("%treeexp_next%",""+legendaryGuild.getFileManager().getConfig().TREEEXP.get(guild.getLevel())));
                    int index = lore.indexOf("%intro%");
                    if (index != -1) {
                        int size = guild.getIntro().size();
                        lore.addAll(index, guild.getIntro());
                        lore.remove(index + size);
                    }

                    id.setLore(lore);
                    if (legendaryGuild.version_high) {
                        id.setCustomModelData(loader.getGuild_model());
                    }
                    i.setItemMeta(id);
                    int slot = layout.get(a);
                    inv.setItem(slot, i);
                    slotToGuild.put(slot,guild);
                    a++;
                }
            }
        });
    }
    public Guild getGuild(int slot){
        return slotToGuild.get(slot);
    }
    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);
        if (!dealEssentailsButton(e.getRawSlot())){
            MenuItem menuItem = getMenuItem(e.getRawSlot());
            if (menuItem != null){
                switch (menuItem.getFuction()){
                    case "pre": {
                        if (page <= 1) {
                            return;
                        }
                        GuildListPanel list = new GuildListPanel(p, (page - 1), sort);
                        list.loadGuilds((page - 1));
                        list.open();
                        break;
                    }
                    case "next": {
                        if (getPage((page + 1)).isEmpty()) {
                            return;
                        }
                        GuildListPanel list = new GuildListPanel(p, (page - 1), sort);
                        list.loadGuilds((page + 1));
                        list.open();
                        break;
                    }
                    case "sort": {
                        int max = Sort.values().length;
                        int index = sort.ordinal();
                        int next = index+1 == max ? 0 : index+1;
                        Sort nextSort = Sort.values()[next];
                        GuildListPanel list = new GuildListPanel(p,1,nextSort);
                        list.loadGuilds(1);
                        list.open();
                        break;
                    }
                }
            }
            else {
                //点击的是公会
                if (slotToGuild.containsKey(e.getRawSlot())){
                    Guild guild = slotToGuild.get(e.getRawSlot());
                    User user = legendaryGuild.getUsersManager().getUser(p.getName());
                    if (user.hasGuild()){
                        p.sendMessage(lang.plugin+lang.already_in_guild);
                        return;
                    }
                    UserAPI.sendApplication(user,guild.getGuild());
                    return;
                }
            }
        }
    }

    public List<Guild> getGuildsBy(Sort sort){
        List<Guild> guilds = legendaryGuild.getGuildsManager().getGuilds().stream().map(s -> {
            return legendaryGuild.getGuildsManager().getGuild(s);
        }).collect(Collectors.toList());
        if (sort.equals(Sort.DEFAULT)){
            return guilds;
        }
        Collections.sort(guilds, new Comparator<Guild>() {
            @Override
            public int compare(Guild o1, Guild o2) {
                switch (sort){
                    case LEVEL:
                        return (o1.getLevel() > o2.getLevel()) ? -1 : ((o1.getLevel() == o2.getLevel()) ? 0 : 1);
                    case MONEY:
                        return (o1.getMoney() > o2.getMoney()) ? -1 : ((o1.getMoney() == o2.getMoney()) ? 0 : 1);
                    case MEMBERS:
                        int a1 = o1.getMembers().size();
                        int a2 = o2.getMembers().size();
                        return (a1 > a2) ? -1 : ((a1 == a2) ? 0 : 1);
                }
                return -1;
            }
        });
        return guilds;
    }

    public int getPage() {
        return page;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }




    public enum Sort{
        MEMBERS("sort_members"),
        LEVEL("sort_level"),
        MONEY("sort_money"),
        DEFAULT("sort_default");
        private String placeholder;

        Sort(String placeholder) {
            this.placeholder = placeholder;
        }

        public String getPlaceholder() {
            return placeholder;
        }
    }





}
