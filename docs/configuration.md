!!! warning
    Helpful Commands 3.0.0 has just been released. It will take some time to write and update the documentation on how to configure the mod and on permissions. Please wait. For now, feel free to ask questions in our [Discord Server](https://discord.gg/RHd8P5hps4).

Helpful Commands is very flexible in terms of configuration. Everything can be done directly in the game and there is no need to manually tinker with the config file.

## 🔰▪ Basics
<div style="display:flex">
    <div class="hc-mic-entry hc-mic-permission" style="margin-right: 10px">
        <div class="hc-mic-logo"><span class="twemoji" title="Permission ID"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M22 4h-8v3h-4V4H2a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h20a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2M8 9a2 2 0 0 1 2 2 2 2 0 0 1-2 2 2 2 0 0 1-2-2 2 2 0 0 1 2-2m4 8H4v-1c0-1.33 2.67-2 4-2s4 .67 4 2v1m8 1h-6v-2h6v2m0-4h-6v-2h6v2m0-4h-6V8h6v2m-7-4h-2V2h2v4Z"></path></svg></span></div><p class="hc-mic-text">helpfulcommands.config</p>
    </div>
    or
    <div class="hc-mic-entry hc-mic-permission" style="margin-left: 10px">
        <div class="hc-mic-logo"><span class="twemoji" title="Permission ID"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M22 4h-8v3h-4V4H2a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h20a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2M8 9a2 2 0 0 1 2 2 2 2 0 0 1-2 2 2 2 0 0 1-2-2 2 2 0 0 1 2-2m4 8H4v-1c0-1.33 2.67-2 4-2s4 .67 4 2v1m8 1h-6v-2h6v2m0-4h-6v-2h6v2m0-4h-6V8h6v2m-7-4h-2V2h2v4Z"></path></svg></span></div><p class="hc-mic-text">helpfulcommands.config.*</p>
    </div>
</div>
All configuration is done with the `/hc config` command. If you don't have a `config` parameter, it means you don't have permissions to configure the mod.

### What can you do and configure
- View a list of all configuration fields, query and update their values
- Manage commands: toggle their active and public states

### Who can configure the mod
#### On dedicated server
- Anyone with OP level of 4
- Anyone who has permissions to do so, which can be set using any permissions management tool (e.g. [LuckPerms](https://luckperms.net/)).

#### On integrated server
For security reasons, only the host can configure the mod. Other players will get an error regardless of their OP level and permissions.

## 📃▪ Command management
<div class="hc-mic-entry hc-mic-permission" style="margin-right: 10px">
    <div class="hc-mic-logo"><span class="twemoji" title="Permission ID"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M22 4h-8v3h-4V4H2a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h20a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2M8 9a2 2 0 0 1 2 2 2 2 0 0 1-2 2 2 2 0 0 1-2-2 2 2 0 0 1 2-2m4 8H4v-1c0-1.33 2.67-2 4-2s4 .67 4 2v1m8 1h-6v-2h6v2m0-4h-6v-2h6v2m0-4h-6V8h6v2m-7-4h-2V2h2v4Z"></path></svg></span></div><p class="hc-mic-text">helpfulcommands.config.manageCommand</p>
</div>

### Toggle command's active state
`/hc config manageCommand <command name> toggleEnabled [state]`
### Toggle command's public state
`/hc config manageCommand <command name> togglePublic [state]`

## 🔧▪ Config field management
<div class="hc-mic-entry hc-mic-permission" style="margin-right: 10px">
    <div class="hc-mic-logo"><span class="twemoji" title="Permission ID"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"><path d="M22 4h-8v3h-4V4H2a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h20a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2M8 9a2 2 0 0 1 2 2 2 2 0 0 1-2 2 2 2 0 0 1-2-2 2 2 0 0 1 2-2m4 8H4v-1c0-1.33 2.67-2 4-2s4 .67 4 2v1m8 1h-6v-2h6v2m0-4h-6v-2h6v2m0-4h-6V8h6v2m-7-4h-2V2h2v4Z"></path></svg></span></div><p class="hc-mic-text">helpfulcommands.config.manageField</p>
</div>

### Query current value
`/hc config manageField <field name> query`
### Update value
`/hc config manageField <field name> set <new value>`