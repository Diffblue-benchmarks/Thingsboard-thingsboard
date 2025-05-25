package org.thingsboard.server.dao.sql.event;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Autowired
  private EventPartitionConfiguration eventPartitionConfiguration;

  /**
   * Test {@link EventPartitionConfiguration#getPartitionSizeInMs(EventType)}.
   * <ul>
   *   <li>When {@code DEBUG_RULE_NODE}.</li>
   *   <li>Then return {@code 3600000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventPartitionConfiguration#getPartitionSizeInMs(EventType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EventPartitionConfiguration.getPartitionSizeInMs(EventType)"})
  public void testGetPartitionSizeInMs_whenDebugRuleNode_thenReturn3600000() {
    // Arrange, Act and Assert
    assertEquals(3600000L, eventPartitionConfiguration.getPartitionSizeInMs(EventType.DEBUG_RULE_NODE));
  }

  /**
   * Test {@link EventPartitionConfiguration#getPartitionSizeInMs(EventType)}.
   * <ul>
   *   <li>When {@code ERROR}.</li>
   *   <li>Then return {@code 604800000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventPartitionConfiguration#getPartitionSizeInMs(EventType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long EventPartitionConfiguration.getPartitionSizeInMs(EventType)"})
  public void testGetPartitionSizeInMs_whenError_thenReturn604800000() {
    // Arrange, Act and Assert
    assertEquals(604800000L, eventPartitionConfiguration.getPartitionSizeInMs(EventType.ERROR));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EventPartitionConfiguration#getDebugPartitionSizeInHours()}
   *   <li>{@link EventPartitionConfiguration#getRegularPartitionSizeInHours()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int EventPartitionConfiguration.getDebugPartitionSizeInHours()",
      "int EventPartitionConfiguration.getRegularPartitionSizeInHours()"})
  public void testGettersAndSetters() {
    // Arrange
    EventPartitionConfiguration eventPartitionConfiguration = new EventPartitionConfiguration();

    // Act
    int actualDebugPartitionSizeInHours = eventPartitionConfiguration.getDebugPartitionSizeInHours();

    // Assert
    assertEquals(0, actualDebugPartitionSizeInHours);
    assertEquals(0, eventPartitionConfiguration.getRegularPartitionSizeInHours());
  }
}
