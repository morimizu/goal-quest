package com.benjaminrperry.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
public abstract class AbstractRabbitClient {

    protected final RabbitSender sender;

}
