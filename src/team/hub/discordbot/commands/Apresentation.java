package team.hub.discordbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Apresentation extends ListenerAdapter {


    /*
     * Construído por Martin Hartfelder
     * 02/05/21
     */


    private static String msgID = null;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        Message msg = event.getMessage();
        EmbedBuilder embed = new EmbedBuilder();

        if (msg.getContentRaw().contains("!hub")) {
            embed.setTitle(":telescope: Olá seja muito bem vindo(a) a nossa comunidade!");
            embed.setDescription("Vim lhe apresentar algumas informações para você, reaja nas opções para visualiza-las. :v: :yum: ");
            embed.addField("", "", false);
            embed.addField(":one: - Informações", "Conheça um pouco sobre nós!", true);
            embed.addField(":two: - Regras", "Veja nossas regras", true);
            embed.addField("", "", false);
            embed.setFooter("HubTech, sua comunidade de desenvolvimento.", msg.getAuthor().getAvatarUrl());
            embed.setTimestamp(msg.getTimeCreated());
            embed.setColor(7419530);
            msg.getAuthor().openPrivateChannel()
                    .complete()
                    .sendMessage(embed.build())
                    .queue(emote -> {
                        msgID = emote.getId();
                        emote.addReaction("1️⃣").queue();
                        emote.addReaction("2️⃣").queue();
                    });
        }
    }

    @Override
    public void onGenericMessageReaction(@NotNull GenericMessageReactionEvent event) {

        EmbedBuilder embed = new EmbedBuilder();

        embed.setColor(7419530);
        embed.setFooter("HubTech, sua comunidade de desenvolvimento.", Objects.requireNonNull(event.getUser()).getAvatarUrl());
        if (msgID != null & (!(event.getUser()).isBot()) & event.getReactionEmote().getName().equals("1️⃣")) {
            embed.setTitle(":orange_book: Informações");
            embed.setDescription("As experiências acumuladas demonstram que a revolução dos costumes maximiza as possibilidades por conta das regras de conduta normativas.\n");
            event.getChannel().sendMessage(embed.build()).complete();
            event.getReaction().removeReaction().queue();
        }

        if (msgID != null & (!(event.getUser()).isBot()) & event.getReactionEmote().getName().equals("2️⃣")) {
            embed.setTitle(":closed_book: Regras");
            embed.setDescription("Fique atento as nossas regras para não ser punido.");
            embed.addField("1. Linguajar severamente vulgar não é permitido.", "", false);
            embed.addField("2. Racismo / Sexismo / Homofobia / Trolagem / Bullying e qualquer forma de ofensa NÃO será tolerado.", "", false);
            embed.addField("3. NÃO envie spam para membros deste servidor.", "", false);
            embed.addField("4. Você pode discutir sobre pirataria, mas NÃO pode postar links ou distribuir qualquer produto e/ou software roubado. Você será banido se for encontrado fazendo isso", "", false);
            embed.addField("5. NÃO deve haver discussão sobre formas de atividades online maliciosas neste servidor.", "", false);
            embed.addField("6. Se você for encontrado postando links maliciosos, você SERÁ banido.", "", false);
            embed.addField("7. Discussão política é permitida, no entanto, mantenha-a de forma amigável e nos canais corretos. Se mudar para uma discussão, você será solicitado a parar ou levar a conversa ao DM.", "", false);
            embed.addField("8. NÃO poste links de convite do Discord. Se quer divulgar alguma comunidade, converse com a Staff e a mesma fará a divulgação se for coerente.","", false);
            embed.addField("9. A autopromoção é permitida, mas pedimos que você poste seus links apenas uma vez por dia e nos canais corretos. Não exagere!","", false);
            embed.addField("10. Utilize corretamente cada sala do servidor para o assunto a qual ela pertence.","", false);
            embed.addField("11. Qualquer dúvida, reclamação, denúncia, etc, entre em contato com membros da Staff (Admins, Moderadores, etc).","", false);
            embed.addField("12. Mais importante: Divirta-se e aproveite sua estadia!", "", false);
            event.getChannel().sendMessage(embed.build()).complete();
            event.getReaction().removeReaction().queue();
        }
    }
}
