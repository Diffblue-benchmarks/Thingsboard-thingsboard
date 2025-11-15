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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TopicService.class})
@ExtendWith(SpringExtension.class)
class TopicServiceDiffblueTest {
  @Autowired
  private TopicService topicService;

  /**
   * Test {@link TopicService#buildTopicName(String)}.
   * <p>
   * Method under test: {@link TopicService#buildTopicName(String)}
   */
  @Test
  @DisplayName("Test buildTopicName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TopicService.buildTopicName(String)"})
  void testBuildTopicName() {
    // Arrange, Act and Assert
    assertEquals("Topic", topicService.buildTopicName("Topic"));
  }

  /**
   * Test {@link TopicService#suffix(Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicService#suffix(Integer)}
   */
  @Test
  @DisplayName("Test suffix(Integer); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TopicService.suffix(Integer)"})
  void testSuffix_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", topicService.suffix(null));
  }

  /**
   * Test {@link TopicService#suffix(Integer)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicService#suffix(Integer)}
   */
  @Test
  @DisplayName("Test suffix(Integer); when one; then return '-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TopicService.suffix(Integer)"})
  void testSuffix_whenOne_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("-1", topicService.suffix(1));
  }
}
