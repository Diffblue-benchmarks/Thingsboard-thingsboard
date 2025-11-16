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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.errors.TopicExistsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TbKafkaAdminDiffblueTest {
  @Mock private Map<String, String> map;

  @InjectMocks private TbKafkaAdmin tbKafkaAdmin;

  @Mock private TbKafkaSettings tbKafkaSettings;

  /**
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   *
   * <ul>
   *   <li>Given {@code 1}.
   *   <li>When {@link HashMap#HashMap()} {@link TbKafkaTopicConfigs#NUM_PARTITIONS_SETTING} is
   *       {@code 1}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName(
      "Test new TbKafkaAdmin(TbKafkaSettings, Map); given '1'; when HashMap() NUM_PARTITIONS_SETTING is '1'; then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaAdmin.<init>(TbKafkaSettings, Map)"})
  void testNewTbKafkaAdmin_given1_whenHashMapNum_partitions_settingIs1_thenHashMapEmpty() {
    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();

    HashMap<String, String> topicConfigs = new HashMap<>();
    topicConfigs.put(TbKafkaTopicConfigs.NUM_PARTITIONS_SETTING, "1");

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert
    assertTrue(topicConfigs.isEmpty());
  }

  /**
   * Test {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}.
   *
   * <ul>
   *   <li>When {@link TbKafkaSettings} (default constructor).
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaAdmin#TbKafkaAdmin(TbKafkaSettings, Map)}
   */
  @Test
  @DisplayName(
      "Test new TbKafkaAdmin(TbKafkaSettings, Map); when TbKafkaSettings (default constructor); then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaAdmin.<init>(TbKafkaSettings, Map)"})
  void testNewTbKafkaAdmin_whenTbKafkaSettings_thenHashMapEmpty() {
    // Arrange
    TbKafkaSettings settings = new TbKafkaSettings();
    HashMap<String, String> topicConfigs = new HashMap<>();

    // Act
    new TbKafkaAdmin(settings, topicConfigs);

    // Assert that nothing has changed
    assertTrue(topicConfigs.isEmpty());
  }

  /**
   * Test {@link TbKafkaAdmin#createTopic(NewTopic)}.
   *
   * <ul>
   *   <li>Given {@link KafkaAdminClient} {@link KafkaAdminClient#createTopics(Collection)} return
   *       {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaAdmin#createTopic(NewTopic)}
   */
  @Test
  @DisplayName(
      "Test createTopic(NewTopic); given KafkaAdminClient createTopics(Collection) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CreateTopicsResult TbKafkaAdmin.createTopic(NewTopic)"})
  void testCreateTopic_givenKafkaAdminClientCreateTopicsReturnNull_thenReturnNull() {
    // Arrange
    KafkaAdminClient kafkaAdminClient = mock(KafkaAdminClient.class);
    when(kafkaAdminClient.createTopics(Mockito.<Collection<NewTopic>>any())).thenReturn(null);
    when(tbKafkaSettings.getAdminClient()).thenReturn(kafkaAdminClient);

    // Act
    CreateTopicsResult actualCreateTopicResult =
        tbKafkaAdmin.createTopic(new NewTopic("Name", 10, (short) 1));

    // Assert
    verify(kafkaAdminClient).createTopics(isA(Collection.class));
    verify(tbKafkaSettings).getAdminClient();
    assertNull(actualCreateTopicResult);
  }

  /**
   * Test {@link TbKafkaAdmin#syncOffsets(String, String, Integer)}.
   *
   * <p>Method under test: {@link TbKafkaAdmin#syncOffsets(String, String, Integer)}
   */
  @Test
  @DisplayName("Test syncOffsets(String, String, Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaAdmin.syncOffsets(String, String, Integer)"})
  void testSyncOffsets() {
    // Arrange
    when(tbKafkaSettings.getAdminClient()).thenThrow(new TopicExistsException("An error occurred"));

    // Act
    tbKafkaAdmin.syncOffsets("42", "42", 1);

    // Assert
    verify(tbKafkaSettings).getAdminClient();
  }

  /**
   * Test {@link TbKafkaAdmin#syncOffsets(String, String, Integer)}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings} {@link TbKafkaSettings#getAdminClient()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaAdmin#syncOffsets(String, String, Integer)}
   */
  @Test
  @DisplayName(
      "Test syncOffsets(String, String, Integer); given TbKafkaSettings getAdminClient() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaAdmin.syncOffsets(String, String, Integer)"})
  void testSyncOffsets_givenTbKafkaSettingsGetAdminClientReturnNull() {
    // Arrange
    when(tbKafkaSettings.getAdminClient()).thenReturn(null);

    // Act
    tbKafkaAdmin.syncOffsets("42", "42", 1);

    // Assert
    verify(tbKafkaSettings).getAdminClient();
  }

  /**
   * Test {@link TbKafkaAdmin#syncOffsets(String, String, Integer)}.
   *
   * <ul>
   *   <li>Then calls {@link KafkaAdminClient#listConsumerGroupOffsets(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaAdmin#syncOffsets(String, String, Integer)}
   */
  @Test
  @DisplayName(
      "Test syncOffsets(String, String, Integer); then calls listConsumerGroupOffsets(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaAdmin.syncOffsets(String, String, Integer)"})
  void testSyncOffsets_thenCallsListConsumerGroupOffsets() {
    // Arrange
    KafkaAdminClient kafkaAdminClient = mock(KafkaAdminClient.class);
    when(kafkaAdminClient.listConsumerGroupOffsets(Mockito.<String>any())).thenReturn(null);
    when(tbKafkaSettings.getAdminClient()).thenReturn(kafkaAdminClient);

    // Act
    tbKafkaAdmin.syncOffsets("42", "42", 1);

    // Assert
    verify(kafkaAdminClient).listConsumerGroupOffsets("42");
    verify(tbKafkaSettings).getAdminClient();
  }
}
