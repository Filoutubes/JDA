/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.internal.interactions.command;

import net.dv8tion.jda.api.interactions.commands.CommandInteraction;
import net.dv8tion.jda.api.interactions.commands.CommandPayload;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.interactions.DeferrableInteractionImpl;
import net.dv8tion.jda.internal.requests.restaction.interactions.ReplyActionImpl;

import javax.annotation.Nonnull;

public class CommandInteractionImpl extends DeferrableInteractionImpl implements CommandInteraction, CommandPayloadMixin
{
    private final CommandPayloadImpl payload;

    public CommandInteractionImpl(JDAImpl jda, DataObject data)
    {
        super(jda, data);
        this.payload = new CommandPayloadImpl(jda, data);
    }

    @Override
    public CommandPayload getCommandPayload()
    {
        return payload;
    }

    @Nonnull
    @Override
    public ReplyAction deferReply()
    {
        return new ReplyActionImpl(hook);
    }
}