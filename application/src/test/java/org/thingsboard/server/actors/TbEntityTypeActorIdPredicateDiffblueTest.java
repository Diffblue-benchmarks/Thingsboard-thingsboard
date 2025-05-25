package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;

@ContextConfiguration(classes = {TbEntityTypeActorIdPredicate.class})
@DisabledInAotMode
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class TbEntityTypeActorIdPredicateDiffblueTest {
  @MockBean
  private EntityType entityType;

  @Autowired
  private TbEntityTypeActorIdPredicate tbEntityTypeActorIdPredicate;

  /**
   * Test {@link TbEntityTypeActorIdPredicate#test(TbActorId)} with {@code TbActorId}.
   * <p>
   * Method under test: {@link TbEntityTypeActorIdPredicate#test(TbActorId)}
   */
  @Test
  @DisplayName("Test test(TbActorId) with 'TbActorId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.test(TbActorId)"})
  void testTestWithTbActorId() {
    // Arrange
    TbEntityActorId actorId = mock(TbEntityActorId.class);
    when(actorId.getEntityId()).thenReturn(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    boolean actualTestResult = tbEntityTypeActorIdPredicate.test(actorId);

    // Assert
    verify(actorId).getEntityId();
    assertFalse(actualTestResult);
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#test(TbActorId)} with {@code TbActorId}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityTypeActorIdPredicate#test(TbActorId)}
   */
  @Test
  @DisplayName("Test test(TbActorId) with 'TbActorId'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.test(TbActorId)"})
  void testTestWithTbActorId_thenReturnTrue() {
    // Arrange
    TbEntityTypeActorIdPredicate tbEntityTypeActorIdPredicate = new TbEntityTypeActorIdPredicate(EntityType.TENANT);
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    TbEntityActorId actorId = mock(TbEntityActorId.class);
    when(actorId.getEntityId()).thenReturn(alarmId);

    // Act
    boolean actualTestResult = tbEntityTypeActorIdPredicate.test(actorId);

    // Assert
    verify(actorId).getEntityId();
    verify(alarmId).getEntityType();
    assertTrue(actualTestResult);
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#test(TbActorId)} with {@code TbActorId}.
   * <ul>
   *   <li>When {@link TbActorId}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityTypeActorIdPredicate#test(TbActorId)}
   */
  @Test
  @DisplayName("Test test(TbActorId) with 'TbActorId'; when TbActorId; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.test(TbActorId)"})
  void testTestWithTbActorId_whenTbActorId_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(tbEntityTypeActorIdPredicate.test(mock(TbActorId.class)));
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}
   */
  @Test
  @DisplayName("Test testEntityId(EntityId); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.testEntityId(EntityId)"})
  void testTestEntityId_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(tbEntityTypeActorIdPredicate
        .testEntityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityTypeActorIdPredicate#testEntityId(EntityId)}
   */
  @Test
  @DisplayName("Test testEntityId(EntityId); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbEntityTypeActorIdPredicate.testEntityId(EntityId)"})
  void testTestEntityId_thenReturnTrue() {
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
}
