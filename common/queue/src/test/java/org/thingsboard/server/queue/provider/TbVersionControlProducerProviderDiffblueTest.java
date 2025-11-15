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
package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class TbVersionControlProducerProviderDiffblueTest {
  /**
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTransportNotificationsMsgProducer()}
   */
  @Test
  void testGetTransportNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbVersionControlProducerProvider(null)).getTransportNotificationsMsgProducer());
  }

  /**
   * Method under test:
   * {@link TbVersionControlProducerProvider#getRuleEngineMsgProducer()}
   */
  @Test
  void testGetRuleEngineMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new TbVersionControlProducerProvider(null)).getRuleEngineMsgProducer());
  }

  /**
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbCoreMsgProducer()}
   */
  @Test
  void testGetTbCoreMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new TbVersionControlProducerProvider(null)).getTbCoreMsgProducer());
  }

  /**
   * Method under test:
   * {@link TbVersionControlProducerProvider#getRuleEngineNotificationsMsgProducer()}
   */
  @Test
  void testGetRuleEngineNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbVersionControlProducerProvider(null)).getRuleEngineNotificationsMsgProducer());
  }

  /**
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbEdgeMsgProducer()}
   */
  @Test
  void testGetTbEdgeMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new TbVersionControlProducerProvider(null)).getTbEdgeMsgProducer());
  }

  /**
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbEdgeNotificationsMsgProducer()}
   */
  @Test
  void testGetTbEdgeNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbVersionControlProducerProvider(null)).getTbEdgeNotificationsMsgProducer());
  }

  /**
   * Method under test:
   * {@link TbVersionControlProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  void testGetTbVersionControlMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbVersionControlProducerProvider(null)).getTbVersionControlMsgProducer());
  }
}
