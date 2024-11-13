package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;

@ContextConfiguration(classes = {TbEntityTypeActorIdPredicate.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbEntityTypeActorIdPredicateDiffblueTest {
  @MockBean
  private EntityType entityType;

  @Autowired
  private TbEntityTypeActorIdPredicate tbEntityTypeActorIdPredicate;

  /**
   * Test {@link TbEntityTypeActorIdPredicate#test(TbActorId)} with
   * {@code TbActorId}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then calls {@link TbEntityActorId#getEntityId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityTypeActorIdPredicate#test(TbActorId)}
   */
  @Test
  @DisplayName("Test test(TbActorId) with 'TbActorId'; given AlarmId(UUID) with id is randomUUID; then calls getEntityId()")
  void testTestWithTbActorId_givenAlarmIdWithIdIsRandomUUID_thenCallsGetEntityId() {
    // Arrange
    TbEntityActorId actorId = mock(TbEntityActorId.class);
    when(actorId.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    boolean actualTestResult = tbEntityTypeActorIdPredicate.test(actorId);

    // Assert
    verify(actorId).getEntityId();
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#test(TbActorId)} with
   * {@code TbActorId}.
   * <ul>
   *   <li>When {@link TbActorId}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityTypeActorIdPredicate#test(TbActorId)}
   */
  @Test
  @DisplayName("Test test(TbActorId) with 'TbActorId'; when TbActorId; then return 'false'")
  void testTestWithTbActorId_whenTbActorId_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(tbEntityTypeActorIdPredicate.test(mock(TbActorId.class)));
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   *   <li>When {@link AlarmId} {@link AlarmId#getEntityType()} return
   * {@code TENANT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}
   */
  @Test
  @DisplayName("Test testEntityId(EntityId); given 'TENANT'; when AlarmId getEntityType() return 'TENANT'; then return 'true'")
  void testTestEntityId_givenTenant_whenAlarmIdGetEntityTypeReturnTenant_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityTypeActorIdPredicate tbEntityTypeActorIdPredicate = new TbEntityTypeActorIdPredicate(EntityType.TENANT);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    boolean actualTestEntityIdResult = tbEntityTypeActorIdPredicate.testEntityId(entityId);

    // Assert
    verify(entityId).getEntityType();
    assertTrue(actualTestEntityIdResult);
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}
   */
  @Test
  @DisplayName("Test testEntityId(EntityId); when AlarmId(UUID) with id is randomUUID; then return 'false'")
  void testTestEntityId_whenAlarmIdWithIdIsRandomUUID_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbEntityTypeActorIdPredicate tbEntityTypeActorIdPredicate = new TbEntityTypeActorIdPredicate(EntityType.TENANT);

    // Act and Assert
    assertFalse(tbEntityTypeActorIdPredicate.testEntityId(new AlarmId(UUID.randomUUID())));
  }
}
