package org.thingsboard.server.service.entitiy.alarm;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.alarm.AlarmCommentService;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.service.entitiy.TbLogEntityActionService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;

@ContextConfiguration(classes = {DefaultTbAlarmCommentService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbAlarmCommentServiceDiffblueTest {
  @MockBean
  private AlarmCommentService alarmCommentService;

  @MockBean
  private AlarmService alarmService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

  @Autowired
  private DefaultTbAlarmCommentService defaultTbAlarmCommentService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntitiesVersionControlService entitiesVersionControlService;

  @MockBean
  private Environment environment;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbLogEntityActionService tbLogEntityActionService;

  /**
   * Test
   * {@link DefaultTbAlarmCommentService#deleteAlarmComment(Alarm, AlarmComment, User)}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbAlarmCommentService#deleteAlarmComment(Alarm, AlarmComment, User)}
   */
  @Test
  @DisplayName("Test deleteAlarmComment(Alarm, AlarmComment, User); when Alarm(); then throw ThingsboardException")
  void testDeleteAlarmComment_whenAlarm_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange
    Alarm alarm = new Alarm();
    AlarmComment alarmComment = new AlarmComment();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTbAlarmCommentService.deleteAlarmComment(alarm, alarmComment, new User()));
  }
}
