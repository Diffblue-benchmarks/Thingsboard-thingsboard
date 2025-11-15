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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rabbitmq.client.ConnectionFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class TbRabbitMqAdminDiffblueTest {
  /**
   * Test {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRabbitMqAdmin#TbRabbitMqAdmin(TbRabbitMqSettings, Map)}
   */
  @Test
  @DisplayName("Test new TbRabbitMqAdmin(TbRabbitMqSettings, Map); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRabbitMqAdmin.<init>(TbRabbitMqSettings, Map)"})
  void testNewTbRabbitMqAdmin_thenThrowRuntimeException() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getByAddress(Mockito.<byte[]>any())).thenReturn(mock(InetAddress.class));
      mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any())).thenReturn(new InetAddress[]{});

      TbRabbitMqSettings rabbitMqSettings = new TbRabbitMqSettings();
      rabbitMqSettings.setConnectionFactory(new ConnectionFactory());

      // Act and Assert
      assertThrows(RuntimeException.class, () -> new TbRabbitMqAdmin(rabbitMqSettings, new HashMap<>()));

      mockInetAddress.verify(() -> InetAddress.getAllByName(Mockito.<String>any()));
    }
  }
}
