package com.mor.trieuvd.basic.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
class User : Serializable {

    @ColumnInfo(name = "login")
    @SerializedName("login")
    @Expose
    var login: String? = null
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @ColumnInfo(name = "node_id")
    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null
    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null
    @ColumnInfo(name = "gravatar_id")
    @SerializedName("gravatar_id")
    @Expose
    var gravatarId: String? = null
    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    var url: String? = null
    @ColumnInfo(name = "html_url")
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    @ColumnInfo(name = "followers_url")
    @SerializedName("followers_url")
    @Expose
    var followersUrl: String? = null
    @ColumnInfo(name = "following_url")
    @SerializedName("following_url")
    @Expose
    var followingUrl: String? = null
    @ColumnInfo(name = "gists_url")
    @SerializedName("gists_url")
    @Expose
    var gistsUrl: String? = null
    @ColumnInfo(name = "starred_url")
    @SerializedName("starred_url")
    @Expose
    var starredUrl: String? = null
    @ColumnInfo(name = "subscriptions_url")
    @SerializedName("subscriptions_url")
    @Expose
    var subscriptionsUrl: String? = null
    @ColumnInfo(name = "organizations_url")
    @SerializedName("organizations_url")
    @Expose
    var organizationsUrl: String? = null
    @ColumnInfo(name = "repos_url")
    @SerializedName("repos_url")
    @Expose
    var reposUrl: String? = null
    @ColumnInfo(name = "events_url")
    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null
    @ColumnInfo(name = "received_events_url")
    @SerializedName("received_events_url")
    @Expose
    var receivedEventsUrl: String? = null
    @ColumnInfo(name = "type")
    @SerializedName("type")
    @Expose
    var type: String? = null
    @ColumnInfo(name = "site_admin")
    @SerializedName("site_admin")
    @Expose
    var siteAdmin: Boolean? = null
    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    var name: String? = null
    @ColumnInfo(name = "company")
    @SerializedName("company")
    @Expose
    var company: String? = null
    @ColumnInfo(name = "blog")
    @SerializedName("blog")
    @Expose
    var blog: String? = null
    @ColumnInfo(name = "location")
    @SerializedName("location")
    @Expose
    var location: String? = null
    @ColumnInfo(name = "email")
    @SerializedName("email")
    @Expose
    var email: Any? = null
    @ColumnInfo(name = "hireable")
    @SerializedName("hireable")
    @Expose
    var hireable: Any? = null
    @ColumnInfo(name = "bio")
    @SerializedName("bio")
    @Expose
    var bio: Any? = null
    @ColumnInfo(name = "public_repos")
    @SerializedName("public_repos")
    @Expose
    var publicRepos: Int? = null
    @ColumnInfo(name = "public_gists")
    @SerializedName("public_gists")
    @Expose
    var publicGists: Int? = null
    @ColumnInfo(name = "followers")
    @SerializedName("followers")
    @Expose
    var followers: Int? = null
    @ColumnInfo(name = "following")
    @SerializedName("following")
    @Expose
    var following: Int? = null
    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null
    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

}
