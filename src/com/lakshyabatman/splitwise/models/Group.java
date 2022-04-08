package com.lakshyabatman.splitwise.models;

public class Group extends Entity{
    public final int groupId, authorId;
    public final GroupMetadata groupMetadata;

    public Group(int groupId, int authorId,  String title, String description) {
        this.groupId = groupId;
        this.authorId = authorId;
        this.groupMetadata = new GroupMetadata(title, description);
    }

}
