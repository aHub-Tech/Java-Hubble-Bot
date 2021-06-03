package team.hub.discordbot.actions;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SuggestController extends ListenerAdapter {

    public static String channelSuggestions = null;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        Message msg = event.getMessage();
        MessageChannel channel = event.getChannel();
        EmbedBuilder embed = new EmbedBuilder();

        if (channel.getId().equals(channelSuggestions) && (!msg.getAuthor().isBot())){
            embed.setTitle("Sugestão");
            embed.setDescription(msg.getContentRaw());
            embed.addField("Autor: ", msg.getAuthor().getAsMention(), false);
            msg.delete().queue();
            embed.setColor(7419530);
            embed.setFooter("HubTech, sua comunidade de desenvolvimento.", msg.getAuthor().getAvatarUrl());
            channel.sendMessage(embed.build()).queue();
        }
    }
}
