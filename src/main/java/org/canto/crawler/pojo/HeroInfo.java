package org.canto.crawler.pojo;

/**
 * @author morningyet
 * @create 2019-09-01 23:20
 * <input type="hidden" name="session_hero_id" value="143040" />
 * * 	<input type="hidden" name="wod_post_id" value="5x0rd1g2k2l9kkh1doawsq0h2jaa9twv" />
 * * 	<input type="hidden" name="wod_post_world" value="CC" />
 * * 	<input type="hidden" name="pay_from_group_cash_box" value="0" />
 * * 	<input type="hidden" name="put_purchases_to" value="go_lager" />
 * * 	<input type="hidden" name="klasse_id" value="59" />
 * * 	<input type="hidden" name="klasse_name" value="法师" />
 * * 	<input type="hidden" name="rasse_id" value="8" />
 * * 	<input type="hidden" name="rasse_name" value="提伦-埃精灵" />
 * * 	<input type="hidden" name="gruppe_id" value="156776" />
 * * 	<input type="hidden" name="gruppe_name" value="jojo的奇妙冒险" />
 * * 	<input type="hidden" name="clan_id"	 value="310" />
 * * 	<input type="hidden" name="clan_name" value="Darkest Dungeon" />
 * * 	<input type="hidden" name="stufe" value="38" />
 * * 	<input type="hidden" name="heldenname" value="爱故乡的歌" />
 * * 	<input type="hidden" name="spielername" value="morningyet" />
 * * 	<input type="hidden" name="display_hero_id" value="143040" />
 */
public class HeroInfo {

    private String session_hero_id;
    private String wod_post_id;
    private String wod_post_world;
    private String pay_from_group_cash_box;
    private String put_purchases_to;
    private String klasse_id; //eg:59
    private String klasse_name;
    private String rasse_id;
    private String rasse_name;
    private String gruppe_id;
    private String gruppe_name;
    private String clan_id;
    private String clan_name;
    private String stufe;
    private String heldenname;
    private String spielername;
    private String display_hero_id;

    public HeroInfo() {
    }

    public HeroInfo(String session_hero_id, String wod_post_id, String wod_post_world, String pay_from_group_cash_box, String put_purchases_to, String klasse_id, String klasse_name, String rasse_id, String rasse_name, String gruppe_id, String gruppe_name, String clan_id, String clan_name, String stufe, String heldenname, String spielername, String display_hero_id) {
        this.session_hero_id = session_hero_id;
        this.wod_post_id = wod_post_id;
        this.wod_post_world = wod_post_world;
        this.pay_from_group_cash_box = pay_from_group_cash_box;
        this.put_purchases_to = put_purchases_to;
        this.klasse_id = klasse_id;
        this.klasse_name = klasse_name;
        this.rasse_id = rasse_id;
        this.rasse_name = rasse_name;
        this.gruppe_id = gruppe_id;
        this.gruppe_name = gruppe_name;
        this.clan_id = clan_id;
        this.clan_name = clan_name;
        this.stufe = stufe;
        this.heldenname = heldenname;
        this.spielername = spielername;
        this.display_hero_id = display_hero_id;
    }

    public String getSession_hero_id() {
        return session_hero_id;
    }

    public void setSession_hero_id(String session_hero_id) {
        this.session_hero_id = session_hero_id;
    }

    public String getWod_post_id() {
        return wod_post_id;
    }

    public void setWod_post_id(String wod_post_id) {
        this.wod_post_id = wod_post_id;
    }

    public String getWod_post_world() {
        return wod_post_world;
    }

    public void setWod_post_world(String wod_post_world) {
        this.wod_post_world = wod_post_world;
    }

    public String getPay_from_group_cash_box() {
        return pay_from_group_cash_box;
    }

    public void setPay_from_group_cash_box(String pay_from_group_cash_box) {
        this.pay_from_group_cash_box = pay_from_group_cash_box;
    }

    public String getPut_purchases_to() {
        return put_purchases_to;
    }

    public void setPut_purchases_to(String put_purchases_to) {
        this.put_purchases_to = put_purchases_to;
    }

    public String getKlasse_id() {
        return klasse_id;
    }

    public void setKlasse_id(String klasse_id) {
        this.klasse_id = klasse_id;
    }

    public String getKlasse_name() {
        return klasse_name;
    }

    public void setKlasse_name(String klasse_name) {
        this.klasse_name = klasse_name;
    }

    public String getRasse_id() {
        return rasse_id;
    }

    public void setRasse_id(String rasse_id) {
        this.rasse_id = rasse_id;
    }

    public String getRasse_name() {
        return rasse_name;
    }

    public void setRasse_name(String rasse_name) {
        this.rasse_name = rasse_name;
    }

    public String getGruppe_id() {
        return gruppe_id;
    }

    public void setGruppe_id(String gruppe_id) {
        this.gruppe_id = gruppe_id;
    }

    public String getGruppe_name() {
        return gruppe_name;
    }

    public void setGruppe_name(String gruppe_name) {
        this.gruppe_name = gruppe_name;
    }

    public String getClan_id() {
        return clan_id;
    }

    public void setClan_id(String clan_id) {
        this.clan_id = clan_id;
    }

    public String getClan_name() {
        return clan_name;
    }

    public void setClan_name(String clan_name) {
        this.clan_name = clan_name;
    }

    public String getStufe() {
        return stufe;
    }

    public void setStufe(String stufe) {
        this.stufe = stufe;
    }

    public String getHeldenname() {
        return heldenname;
    }

    public void setHeldenname(String heldenname) {
        this.heldenname = heldenname;
    }

    public String getSpielername() {
        return spielername;
    }

    public void setSpielername(String spielername) {
        this.spielername = spielername;
    }

    public String getDisplay_hero_id() {
        return display_hero_id;
    }

    public void setDisplay_hero_id(String display_hero_id) {
        this.display_hero_id = display_hero_id;
    }

    @Override
    public String toString() {
        return "HeroInfo{" + "\r\n" +
                "  session_hero_id='" + session_hero_id + '\'' + "\r\n" +
                ", wod_post_id='" + wod_post_id + '\'' + "\r\n" +
                ", wod_post_world='" + wod_post_world + '\'' + "\r\n" +
                ", pay_from_group_cash_box='" + pay_from_group_cash_box + '\'' + "\r\n" +
                ", put_purchases_to='" + put_purchases_to + '\'' + "\r\n" +
                ", klasse_id='" + klasse_id + '\'' + "\r\n" +
                ", klasse_name='" + klasse_name + '\'' + "\r\n" +
                ", rasse_id='" + rasse_id + '\'' + "\r\n" +
                ", rasse_name='" + rasse_name + '\'' + "\r\n" +
                ", gruppe_id='" + gruppe_id + '\'' + "\r\n" +
                ", gruppe_name='" + gruppe_name + '\'' + "\r\n" +
                ", clan_id='" + clan_id + '\'' + "\r\n" +
                ", clan_name='" + clan_name + '\'' + "\r\n" +
                ", stufe='" + stufe + '\'' + "\r\n" +
                ", heldenname='" + heldenname + '\'' + "\r\n" +
                ", spielername='" + spielername + '\'' + "\r\n" +
                ", display_hero_id='" + display_hero_id + '\'' + "\r\n" +
                '}';
    }
}
