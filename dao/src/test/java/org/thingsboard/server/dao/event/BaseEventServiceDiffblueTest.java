package org.thingsboard.server.dao.event;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseEventService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseEventServiceDiffblueTest {
  @Autowired
  private BaseEventService baseEventService;

  @MockBean
  private DataValidator<Event> dataValidator;

  @MockBean
  private EventDao eventDao;

  /**
   * Test {@link BaseEventService#cleanupEvents(long, long, boolean)}.
   * <p>
   * Method under test: {@link BaseEventService#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseEventService.cleanupEvents(long, long, boolean)"})
  public void testCleanupEvents() {
    // Arrange
    doNothing().when(eventDao).cleanupEvents(anyLong(), anyLong(), anyBoolean());

    // Act
    baseEventService.cleanupEvents(1L, 1L, true);

    // Assert
    verify(eventDao).cleanupEvents(eq(1L), eq(1L), eq(true));
  }
}
