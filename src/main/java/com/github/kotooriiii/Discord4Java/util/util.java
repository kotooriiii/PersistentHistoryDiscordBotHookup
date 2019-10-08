package com.github.kotooriiii.Discord4Java.util;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class util {
    public static boolean isStaff(IUser user, IChannel channel) {

        IGuild guild = channel.getGuild();
        List<IRole> roles = user.getRolesForGuild(guild);

        List<String> allValidRoles = getStaffList(user, channel, 3);

        for (IRole role : roles) {
            String roles_string = role.getName();
            for (String validRoles : allValidRoles) {

                if (roles_string.equalsIgnoreCase(validRoles)) {
                    return true;
                }
            }

        }
        return false;

    }

    public static boolean isStaff(IUser user, IChannel channel, int accesscode) {
        IGuild guild = channel.getGuild();
        List<IRole> roles = user.getRolesForGuild(guild);

        List<String> allValidRoles = getStaffList(user, channel, accesscode);

        for (IRole role : roles) {
            String roles_string = role.getName();
            for (String validRoles : allValidRoles) {

                if (roles_string.equalsIgnoreCase(validRoles)) {
                    return true;
                }
            }

        }
        return false;

    }

    public static boolean isStaff(IUser user, IChannel channel, List<String> rolename) {

        IGuild guild = channel.getGuild();
        List<IRole> roles = user.getRolesForGuild(guild);

        for (IRole role : roles) {
            String roles_string = role.getName();
            for (String listed_roles : rolename) {
                if (roles_string.equalsIgnoreCase(listed_roles)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isStaff(IUser user, IChannel channel, String rolename) {

        IGuild guild = channel.getGuild();
        List<IRole> roles = user.getRolesForGuild(guild);

        for (IRole role : roles) {
            String roles_string = role.getName();
            if (roles_string.equalsIgnoreCase(rolename)) {
                return true;
            }
        }
        return false;
    }

    private static List<String> getStaffList(IUser user, IChannel channel, int accesscode) {

        IGuild guild = channel.getGuild();
        List<IRole> roles = user.getRolesForGuild(guild);

        List<String> ac1 = new ArrayList<String>(Arrays.asList("OWNER", "MANAGER", "PLUGIN DEVELOPER", "DEVELOPER"));
        List<String> ac2 =  new ArrayList<String>(Arrays.asList("ADMIN", "ADMINSTRATOR", "ADMINSTRATORS"));
        List<String> ac3 =  new ArrayList<String>(Arrays.asList("MODERATOR", "MOD"));
        List<String> ac4 = new ArrayList<String>( Arrays.asList("HELPER"));

        switch (accesscode) {
            case 1:
                return ac1;
            case 2:
                ac2.addAll(ac1);
                return ac2;
            case 3:
                ac3.addAll(ac1);
                ac3.addAll(ac2);
                return ac3;
            case 4:
                ac4.addAll(ac1);
                ac4.addAll(ac2);
                ac4.addAll(ac3);
                return ac4;
            default:
                return Arrays.asList("");
        }
    }

    @Deprecated
    private static List<String> getRolesList(IUser user, IChannel channel, int accesscode) {

        IGuild guild = channel.getGuild();
        List<IRole> roles = user.getRolesForGuild(guild);

        List<String> ac1 = Arrays.asList("OWNER", "MANAGER", "PLUGIN DEVELOPER", "DEVELOPER");
        List<String> ac2 = Arrays.asList("ADMIN", "ADMINSTRATOR", "ADMINSTRATORS");
        List<String> ac3 = Arrays.asList("MODERATOR", "MOD");
        List<String> ac4 = Arrays.asList("HELPER");
        List<String> ac5 = Arrays.asList("DONATOR");

        switch (accesscode) {
            case 1:
                //return owner, co-owner, cofoudner, head admin, chair , CoS, manager, DEVS
                return ac1;
            case 2:
                ac2.addAll(ac1);
                return ac2;
            case 3:
                ac3.addAll(ac1);
                ac3.addAll(ac2);
                return ac3;
            case 4:
                ac4.addAll(ac1);
                ac4.addAll(ac2);
                ac4.addAll(ac3);
                return ac4;
            case 5:
                ac5.addAll(ac1);
                ac5.addAll(ac2);
                ac5.addAll(ac3);
                ac5.addAll(ac4);
                return ac5;
            default:
                return Arrays.asList("");
        }
    }
}
