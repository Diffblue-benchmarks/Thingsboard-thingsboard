/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.queue.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import com.rabbitmq.client.ConnectionFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;

class TbRabbitMqConsumerTemplateDiffblueTest {
  /**
   * Method under test:
   * {@link TbRabbitMqConsumerTemplate#TbRabbitMqConsumerTemplate(TbQueueAdmin, TbRabbitMqSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  void testNewTbRabbitMqConsumerTemplate() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByAddress(Mockito.<byte[]>any())).thenReturn(mock(InetAddress.class));
      mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any())).thenReturn(new InetAddress[]{});

      TbRabbitMqSettings rabbitMqSettings = new TbRabbitMqSettings();
      rabbitMqSettings.setConnectionFactory(new ConnectionFactory());

      // Act and Assert
      assertThrows(RuntimeException.class,
          () -> new TbRabbitMqConsumerTemplate<>(null, rabbitMqSettings, "Topic", mock(TbQueueMsgDecoder.class)));

      mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
    }
  }
}
