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
package org.thingsboard.server.dao.sql.event;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.event.EventType;

@ContextConfiguration(classes = {EventPartitionConfiguration.class})
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class EventPartitionConfigurationDiffblueTest {
  @Autowired private EventPartitionConfiguration eventPartitionConfiguration;

  /**
   * Test {@link EventPartitionConfiguration#getPartitionSizeInMs(EventType)}.
   *
   * <ul>
   *   <li>When {@code DEBUG_RULE_NODE}.
   *   <li>Then return {@code 3600000}.
   * </ul>
   *
   * <p>Method under test: {@link EventPartitionConfiguration#getPartitionSizeInMs(EventType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long EventPartitionConfiguration.getPartitionSizeInMs(EventType)"})
  public void testGetPartitionSizeInMs_whenDebugRuleNode_thenReturn3600000() {
    // Arrange, Act and Assert
    assertEquals(
        3600000L, eventPartitionConfiguration.getPartitionSizeInMs(EventType.DEBUG_RULE_NODE));
  }

  /**
   * Test {@link EventPartitionConfiguration#getPartitionSizeInMs(EventType)}.
   *
   * <ul>
   *   <li>When {@code ERROR}.
   *   <li>Then return {@code 604800000}.
   * </ul>
   *
   * <p>Method under test: {@link EventPartitionConfiguration#getPartitionSizeInMs(EventType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long EventPartitionConfiguration.getPartitionSizeInMs(EventType)"})
  public void testGetPartitionSizeInMs_whenError_thenReturn604800000() {
    // Arrange, Act and Assert
    assertEquals(604800000L, eventPartitionConfiguration.getPartitionSizeInMs(EventType.ERROR));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventPartitionConfiguration#getDebugPartitionSizeInHours()}
   *   <li>{@link EventPartitionConfiguration#getRegularPartitionSizeInHours()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int EventPartitionConfiguration.getDebugPartitionSizeInHours()",
    "int EventPartitionConfiguration.getRegularPartitionSizeInHours()"
  })
  public void testGettersAndSetters() {
    // Arrange
    EventPartitionConfiguration eventPartitionConfiguration = new EventPartitionConfiguration();

    // Act
    int actualDebugPartitionSizeInHours =
        eventPartitionConfiguration.getDebugPartitionSizeInHours();

    // Assert
    assertEquals(0, actualDebugPartitionSizeInHours);
    assertEquals(0, eventPartitionConfiguration.getRegularPartitionSizeInHours());
  }
}
