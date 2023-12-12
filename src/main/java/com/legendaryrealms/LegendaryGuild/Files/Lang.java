package com.legendaryrealms.LegendaryGuild.Files;

import com.legendaryrealms.LegendaryGuild.LegendaryGuild;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lang extends FileProvider{
    private LangType type;

    public Lang(LegendaryGuild legendaryGuild) {
        super(legendaryGuild,"./plugins/LegendaryGuild/Lang","Lang/",legendaryGuild.lang.name()+".yml");
    }

    public String plugin;
    public String unknown_command;
    public String nopermission;
    public String already_in_guild;
    public String notmath;
    public String notguild;
    public String notplayer;
    public String nothasguild;
    public String notowner;
    public String notmember;
    public String vault_noenough;
    public String no_guildmoney;
    public String noenough_level;
    public String noenough_treelevel;
    public String noenough_members;
    public String noenough_guildpoints;
    public String nopass_position;
    public String nopass_chance;
    public String no_panel;
    public String isowner;
    public String member_max;
    public List<String> help_player;
    public List<String> help_admin;
    public String uset_recive_points;
    public String uset_decrease_points;
    public String uset_set_points;
    public String user_set_position;
    public String admin_target_nothasguild;
    public String admin_give_points;
    public String admin_take_points;
    public String admin_set_points;
    public String admin_set_position_null;
    public String admin_set_position;
    public String admin_set_position_cant;
    public String admin_set_position_cant_owner;
    public String admin_set_position_cant_max;
    public String admin_give_money;
    public String admin_take_money;
    public String admin_set_money;
    public String admin_level_add;
    public String admin_level_take;
    public String admin_level_set;
    public String admin_exp_add;
    public String admin_exp_take;
    public String admin_exp_set;
    public String admin_treeexp_add;
    public String admin_treeexp_take;
    public String admin_treeexp_set;
    public String admin_treelevel_add;
    public String admin_treelevel_set;
    public String admin_treelevel_take;
    public String admin_bufflevel_add;
    public String admin_bufflevel_take;
    public String admin_bufflevel_set;
    public String admin_buff_null;
    public String default_null;
    public String default_guild;
    public String default_position;
    public String default_intro;
    public String default_notice;
    public String create_cooldown;
    public String create_length;
    public String create_exists;
    public String create_message;
    public List<String> create_broad;
    public String reuirement_notenough_vault;
    public String reuirement_notenough_playerpoints;
    public String requirement_notenough_item;
    public String application_send;
    public String application_recive;
    public String application_already;
    public String application_already_in_guild;
    public String application_wait;
    public String application_pass;
    public String application_join;
    public String application_join_broad;
    public String members_kick;
    public String members_kick_broad;
    public String members_bekick;
    public String stores_unlock;
    public String stores_unlock_broad;
    public String stores_has_used;
    public String stores_add_white;
    public String stores_add_white_already;
    public String stores_remove_white;
    public String stores_remove_white_null;
    public String stores_add_white_title;
    public String stores_remove_white_title;
    public String stores_cant_use;
    public String redpacket_min_total;
    public String redpacket_min_amount;
    public String redpacket_create;
    public String redpacket_create_broad;
    public String redpacket_garb_no;
    public String redpacket_garb_already;
    public String redpacket_garb;
    public String redpacket_garb_finally;
    public String redpacket_create_amount_max;
    public String level_levelup;
    public List<String> level_levelup_broad;
    public String level_expadd;
    public String tree_levelup;
    public String tree_levelup_cant;
    public String tree_levelup_byplayer;
    public String tree_level_large;
    public String tree_level_max;
    public String tree_expadd_byplayer;
    public String tree_wish;
    public String tree_wish_broad;
    public String tree_wish_already;
    public String tree_water;
    public String tree_water_broad;
    public String tree_water_limit;
    public String icon_unlock;
    public String icon_locked;
    public String icon_put;
    public String shop_buy;
    public String shop_limit;
    public String buff_levelup;
    public String buff_max;


    @Override
    public void readDefault() {

        this.plugin = legendaryGuild.color(getValue("plugin","&b&lLegendary&3&lGuild"));
        this.unknown_command = legendaryGuild.color(getValue("unknown_command","&f该指令不存在或格式出错！"));
        this.nopermission = legendaryGuild.color(getValue("nopermission","&f你没有该权限！"));
        this.already_in_guild = legendaryGuild.color(getValue("already_in_guild","&f你已经在一个公会内了"));
        this.nothasguild = legendaryGuild.color(getValue("nothasguild","&f你不在一个公会内！"));
        this.notowner = legendaryGuild.color(getValue("notowner","&f你不是会长！"));
        this.notmember = legendaryGuild.color(getValue("notmember","&f公会内没有该成员"));
        this.no_guildmoney = legendaryGuild.color(getValue("no_guildmoney","&f公会资金不足 &e%value%"));
        this.noenough_level = legendaryGuild.color(getValue("noenough_level","&f公会等级不足 &e%value%"));
        this.noenough_treelevel = legendaryGuild.color(getValue("noenough_treelevel","&f公会神树等级不足 &e%value%"));
        this.noenough_members = legendaryGuild.color(getValue("noenough_members","&f公会成员人数不足 &e%value%"));
        this.noenough_guildpoints = legendaryGuild.color(getValue("noenough_guildpoints","&f你的公会贡献值不足 &e%value%"));
        this.nopass_position = legendaryGuild.color(getValue("nopass_position","&c你的公会职位不允许进行该操作."));
        this.nopass_chance = legendaryGuild.color(getValue("nopass_chance","&c你的运气似乎不太好..."));
        this.no_panel = legendaryGuild.color(getValue("no_panel","&f没有该界面."));
        this.vault_noenough = legendaryGuild.color(getValue("vault_noenough","&f你的游戏币不足 &e%value%"));
        this.member_max = legendaryGuild.color(getValue("member_max","&f公会人数已满，无法再招募更多成员！"));
        this.isowner = legendaryGuild.color(getValue("isowner","&f该玩家是会长！"));

        this.help_player = legendaryGuild.color(getValue("help_player",new ArrayList<>()));
        this.help_admin = legendaryGuild.color(getValue("help_admin",new ArrayList<>()));

        this.notmath = legendaryGuild.color(getValue("notmath","&f请输入正确的数字！"));
        this.notguild = legendaryGuild.color(getValue("notguild","该公会不存在！"));
        this.notplayer = legendaryGuild.color(getValue("notplayer","&f该玩家不存在！"));

        this.uset_recive_points = legendaryGuild.color(getValue("user.recive_points","&f你的公会贡献点增加了 &a%value%"));
        this.uset_decrease_points = legendaryGuild.color(getValue("user.decrease_points","&f你的公会贡献点减少了 &a%value%"));
        this.uset_set_points = legendaryGuild.color(getValue("user.set_points","&f你的公会贡献点被设置为 &a%value%"));
        this.user_set_position = legendaryGuild.color(getValue("user.set_position","&f你的公会职位变化为 &a%value%"));

        this.admin_give_points = legendaryGuild.color(getValue("admin.give_points","&f玩家 &e%target% &f的公会贡献点增加了 &a%value%"));
        this.admin_take_points = legendaryGuild.color(getValue("admin.take_points","&f玩家 &e%target% &f的公会贡献点减少了 &a%value%"));
        this.admin_set_points = legendaryGuild.color(getValue("admin.set_points","&f玩家 &e%target% &f的公会贡献被设置为 &a%value%"));
        this.admin_target_nothasguild = legendaryGuild.color(getValue("admin.target_nothasguild","&f该玩家不在公会内."));
        this.admin_set_position_null = legendaryGuild.color(getValue("admin.set_position_null","&f该职位不存在！"));
        this.admin_set_position = legendaryGuild.color(getValue("admin.set_position","&f玩家 &e%target% &f的职位被设置为 &a%value%"));
        this.admin_set_position_cant = legendaryGuild.color(getValue("admin.set_position_cant","&f该玩家是公会会长，无法变更职位！"));
        this.admin_set_position_cant_owner = legendaryGuild.color(getValue("admin.set_position_cant_owner","&f会长这个职位无法被任命"));
        this.admin_set_position_cant_max = legendaryGuild.color(getValue("admin.set_position_cant_max","&f该公会的该职位人数达到上限.."));
        this.admin_give_money = legendaryGuild.color(getValue("admin.give_money","&f公会 &e%target% &f的资金增加了 &a%value%"));
        this.admin_take_money = legendaryGuild.color(getValue("admin.take_money","&f公会 &e%target% &f的资金减少了 &a%value%"));
        this.admin_set_money = legendaryGuild.color(getValue("admin.set_money","&f公会 &e%target% &f的资金被设置为 &a%value%"));
        this.admin_level_set = legendaryGuild.color(getValue("admin.level_set","&f你将公会 %target% &f的等级设置为 &a%value% &f级"));
        this.admin_level_add = legendaryGuild.color(getValue("admin.level_add","&f你将公会 %target% &f的等级提升了 &a%value% &f级"));
        this.admin_level_take= legendaryGuild.color(getValue("admin.level_take","&f你将公会 %target% &f的等级减少了 &a%value% &f级"));
        this.admin_exp_add = legendaryGuild.color(getValue("admin.exp_add","&f你将公会 &e%target% &f的经验提升了 &e%value%"));
        this.admin_exp_take = legendaryGuild.color(getValue("admin.exp_take","&f你将公会 &e%target% &f的经验减少了 &e%value%"));
        this.admin_exp_set = legendaryGuild.color(getValue("admin.exp_set","&f你将公会 &e%target% &f的经验设置为 &e%value%"));
        this.admin_treelevel_set = legendaryGuild.color(getValue("admin.treelevel_set","&f你将公会 %target% &f的公会神树等级设置为 &a%value% &f级"));
        this.admin_treelevel_add = legendaryGuild.color(getValue("admin.treelevel_add","&f你将公会 %target% &f的公会神树等级提升了 &a%value% &f级"));
        this.admin_treelevel_take= legendaryGuild.color(getValue("admin.treelevel_take","&f你将公会 %target% &f的公会神树等级减少了 &a%value% &f级"));
        this.admin_treeexp_add = legendaryGuild.color(getValue("admin.treeexp_add","&f你将公会 &e%target% &f的公会神树成长值提升了 &e%value%"));
        this.admin_treeexp_take = legendaryGuild.color(getValue("admin.treeexp_take","&f你将公会 &e%target% &f的公会神树成长值减少了 &e%value%"));
        this.admin_treeexp_set = legendaryGuild.color(getValue("admin.treeexp_set","&f你将公会 &e%target% &f的公会神树成长值设置为 &e%value%"));
        this.admin_bufflevel_add = legendaryGuild.color(getValue("admin.bufflevel_add","&f你将公会 &e%target% &f的buff %buff% &f等级提升了 &e%value% &f级！"));
        this.admin_bufflevel_take = legendaryGuild.color(getValue("admin.bufflevel_take","&f你将公会 &e%target% &f的buff %buff% &f等级降低了 &e%value% &f级！"));
        this.admin_bufflevel_set = legendaryGuild.color(getValue("admin.bufflevel_set","&f你将公会 &e%target% &f的buff %buff% &f等级设置为 &e%value% &f级！"));
        this.admin_buff_null = legendaryGuild.color(getValue("admin.buff_null","&f该buff不存在！"));

        this.default_null = legendaryGuild.color(getValue("default.null","无"));
        this.default_guild = legendaryGuild.color(getValue("default.guild","无公会"));
        this.default_position = legendaryGuild.color(getValue("default.position","无职位"));
        this.default_intro = legendaryGuild.color(getValue("default.intro","这个公会的会长很懒,还没有留下任何介绍"));
        this.default_notice = legendaryGuild.color(getValue("default.notice","这个公会的会长很懒,还没有留下任何公告"));

        this.create_cooldown = legendaryGuild.color(getValue("create.cooldown","&f你还需等待 &c%value%s &f后才能加入或者创建新的公会"));
        this.create_length = legendaryGuild.color(getValue("create.length","&f该公会名称过长！"));
        this.create_exists = legendaryGuild.color(getValue("create.exists","&f该公会名称已经存在了！"));
        this.create_message = legendaryGuild.color(getValue("create.message","&f你成功创建了公会 &e%value% &f赶快邀请玩家加入你的公会吧！"));
        this.create_broad = legendaryGuild.color(getValue("create.broad",new ArrayList<>()));

        this.reuirement_notenough_vault = legendaryGuild.color(getValue("requirements.notenough_vault","&f你的游戏币不足 &e%value%"));
        this.reuirement_notenough_playerpoints = legendaryGuild.color(getValue("requirements.notenough_playerpoints","&f你的点券不足 &e%value%"));
        this.requirement_notenough_item = legendaryGuild.color(getValue("requirements.notenough_item","&f你的 %item% &f不足 &e%value%个"));

        this.application_send = legendaryGuild.color(getValue("application.send","&f你向 %value% &f发送了入会申请,请等待会长审核."));
        this.application_recive = legendaryGuild.color(getValue("application.recive","&f玩家 &e%player% &f想要加入公会,请及时处理入会申请.."));
        this.application_already = legendaryGuild.color(getValue("application.already","&f你已经向该公会发送过申请了,请等待审核."));
        this.application_already_in_guild = legendaryGuild.color(getValue("application.already_in_guild","&f该玩家已经加入了其他的公会了.."));
        this.application_wait = legendaryGuild.color(getValue("application.wait","&f你目前有 &e%value% &f个入会申请待处理.."));
        this.application_pass = legendaryGuild.color(getValue("application.pass","&f你通过了玩家 &e%value% &f的入会申请."));
        this.application_join = legendaryGuild.color(getValue("application.join","&f你加入了公会 %value%"));
        this.application_join_broad = legendaryGuild.color(getValue("application.join_broad","&f新的成员 &e%value% &f加入了我们的公会！"));

        this.members_kick = legendaryGuild.color(getValue("members.kick","&f你将 &e%value% &f踢出了公会."));
        this.members_kick_broad = legendaryGuild.color(getValue("members.kick_broad","&f公会成员 &e%value% &f被踢出了公会."));
        this.members_bekick = legendaryGuild.color(getValue("members.bekick","&f你被 &e%value% &f的会长踢出了公会..."));

        this.stores_unlock = legendaryGuild.color(getValue("stores.unlock","&f你将公会 &E%value%号仓库 &f解锁了！"));
        this.stores_unlock_broad = legendaryGuild.color(getValue("stores.unlock_broad","&f公会解锁了 &e%value%号仓库！"));
        this.stores_has_used = legendaryGuild.color(getValue("stores.has_used","&f该仓库有成员正在使用.."));
        this.stores_add_white = legendaryGuild.color(getValue("stores.add_white","&f你成功对 &e%target% &f开放使用 &e%value%号仓库"));
        this.stores_add_white_already = legendaryGuild.color(getValue("stores.add_white_already","&f该成员已经在该号仓库的白名单内"));
        this.stores_remove_white = legendaryGuild.color(getValue("stores.remove_white","&f你已关闭 &e%target% &f的 &3%value%号仓库 &f使用权"));
        this.stores_remove_white_null = legendaryGuild.color(getValue("stores.remove_white_null","&f该仓库的白名单内没有该成员"));
        this.stores_add_white_title = legendaryGuild.color(getValue("stores.add_white_title","&f请输入添加到该仓库白名单的成员名字"));
        this.stores_remove_white_title = legendaryGuild.color(getValue("stores.remove_white_title","&f请输入移除该仓库白名单内的成员名字"));
        this.stores_cant_use = legendaryGuild.color(getValue("stores.cant_use","&f该仓库被设置了权限，你不在该仓库的信任名单内"));

        this.redpacket_min_amount = legendaryGuild.color(getValue("redpacket.min_amount","&f最少红包份数为&e 2个"));
        this.redpacket_min_total = legendaryGuild.color(getValue("redpacket.min_total","&f最低红包金额为 &e100.0"));
        this.redpacket_create = legendaryGuild.color(getValue("redpacket.create","&f你发放了一个公会红包，总金额 &e%total% &f共 &e%amount% &f份."));
        this.redpacket_create_broad = legendaryGuild.color(getValue("redpacket.create_broad","&f公会成员 &e%target% &f发放了总金额为 &e%total% &f的红包，共 &e%amount% &f份！赶快抢吧！"));
        this.redpacket_garb_no = legendaryGuild.color(getValue("redpacket.garb_no","&f你来迟了，该红包已经被瓜分完了..."));
        this.redpacket_garb_already = legendaryGuild.color(getValue("redpacket.garb_already","&f你已经领取过该红包了.."));
        this.redpacket_garb = legendaryGuild.color(getValue("redpacket.garb","&f公会成员 &e%target% &f领取了 &e%value% &f发放的红包，获得了 &e%money%游戏币"));
        this.redpacket_garb_finally = legendaryGuild.color(getValue("redpacket.garb_finally","&f公会成员 &e%target% &f发放的红包已被领取完毕,运气王是 &e%luck% &f金额为 &e%value%"));
        this.redpacket_create_amount_max = legendaryGuild.color(getValue("redpacket.create_amount_max","&f红包数量不能超过公会成员的人数"));

        this.level_levelup = legendaryGuild.color(getValue("level.levelup","'&f公会等级提升！目前等级为 &e%value%"));
        this.level_levelup_broad = legendaryGuild.color(getValue("level.levelup_broad", Arrays.asList(" ","&7[&6公会&7] &f公会 &e%target% &f的等级提升为 &e%value%！"," ")));
        this.level_expadd = legendaryGuild.color(getValue("level.expadd","&f公会经验增加了 &e%value%"));

        this.tree_levelup = legendaryGuild.color(getValue("tree.levelup","&f公会神树等级提示！当前等级为 &e%value%"));
        this.tree_levelup_byplayer = legendaryGuild.color(getValue("tree.levelup_byplayer","&f你成功提升了公会神树的等级！"));
        this.tree_level_large = legendaryGuild.color(getValue("tree.level_large","&f神树等级无法超过公会等级！"));
        this.tree_levelup_cant = legendaryGuild.color(getValue("tree.levelup_cant","公会神树成长值不足！无法升级..."));
        this.tree_level_max = legendaryGuild.color(getValue("tree.level_max","&f神树等级已达到上限."));
        this.tree_expadd_byplayer = legendaryGuild.color(getValue("tree.expadd_byplayer","&f公会神树成长值提升了 &a%value%"));
        this.tree_wish = legendaryGuild.color(getValue("tree.wish","&a许愿成功！获得神树的馈赠！"));
        this.tree_wish_broad = legendaryGuild.color(getValue("tree.wish_broad","&f公会成员 &e%target% &f今日完成神树许愿并获得了神树的馈赠！"));
        this.tree_wish_already = legendaryGuild.color(getValue("tree.wish_already","&f你今日已经许愿过了.."));
        this.tree_water = legendaryGuild.color(getValue("tree.water","&f你成功使用 %value% &f为神树浇灌！"));
        this.tree_water_broad = legendaryGuild.color(getValue("tree.water_broad","&f公会成员使用 %value% &f为神树进行了浇灌."));
        this.tree_water_limit = legendaryGuild.color(getValue("tree.water_limit","&f你今日不能再使用该水壶了！"));

        this.icon_unlock = legendaryGuild.color(getValue("icon.unlock","&f你为公会解锁了公会图标 %value%"));
        this.icon_locked = legendaryGuild.color(getValue("icon.locked","&f该图标还未解锁"));
        this.icon_put = legendaryGuild.color(getValue("icon.put","&f你将公会图标更改为 %value%"));

        this.shop_buy = legendaryGuild.color(getValue("shop.buy","&f你购买了 %value%"));
        this.shop_limit = legendaryGuild.color(getValue("shop.limit","&f你不能再购买该商品了..."));

        this.buff_levelup = legendaryGuild.color(getValue("buff.levelup","&d公会buff %target% &d等级提升,目前为 &e%value% &d级."));
        this.buff_max = legendaryGuild.color(getValue("buff.max","&c该Buff的等级已经达到上限."));


        saveYml();
    }

    public enum LangType {
        Chinese,English
    }
}
