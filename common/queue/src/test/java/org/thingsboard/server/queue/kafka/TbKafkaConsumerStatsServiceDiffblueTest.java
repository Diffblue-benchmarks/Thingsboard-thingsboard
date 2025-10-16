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
package org.thingsboard.server.queue.kafka;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class TbKafkaConsumerStatsServiceDiffblueTest {
  @Mock private TbKafkaConsumerStatisticConfig tbKafkaConsumerStatisticConfig;

  @InjectMocks private TbKafkaConsumerStatsService tbKafkaConsumerStatsService;

  /**
   * Test {@link TbKafkaConsumerStatsService#init()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaConsumerStatisticConfig#getEnabled()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#init()}
   */
  @Test
  @DisplayName("Test init(); then calls getEnabled()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.init()"})
  void testInit_thenCallsGetEnabled() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(false);

    // Act
    tbKafkaConsumerStatsService.init();

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaConsumerStatisticConfig} {@link
   *       TbKafkaConsumerStatisticConfig#getEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName(
      "Test registerClientGroup(String); given TbKafkaConsumerStatisticConfig getEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.registerClientGroup(String)"})
  void testRegisterClientGroup_givenTbKafkaConsumerStatisticConfigGetEnabledReturnFalse() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(false);

    // Act
    tbKafkaConsumerStatsService.registerClientGroup("42");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.registerClientGroup(String)"})
  void testRegisterClientGroup_when42() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.registerClientGroup("42");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.registerClientGroup(String)"})
  void testRegisterClientGroup_whenEmptyString() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.registerClientGroup("");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  @DisplayName("Test registerClientGroup(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.registerClientGroup(String)"})
  void testRegisterClientGroup_whenNull() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.registerClientGroup(null);

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.unregisterClientGroup(String)"})
  void testUnregisterClientGroup() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(false);

    // Act
    tbKafkaConsumerStatsService.unregisterClientGroup("42");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.unregisterClientGroup(String)"})
  void testUnregisterClientGroup_when42() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.unregisterClientGroup("42");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.unregisterClientGroup(String)"})
  void testUnregisterClientGroup_whenEmptyString() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.unregisterClientGroup("");

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }

  /**
   * Test {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  @DisplayName("Test unregisterClientGroup(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaConsumerStatsService.unregisterClientGroup(String)"})
  void testUnregisterClientGroup_whenNull() {
    // Arrange
    when(tbKafkaConsumerStatisticConfig.getEnabled()).thenReturn(true);

    // Act
    tbKafkaConsumerStatsService.unregisterClientGroup(null);

    // Assert
    verify(tbKafkaConsumerStatisticConfig).getEnabled();
  }
}
