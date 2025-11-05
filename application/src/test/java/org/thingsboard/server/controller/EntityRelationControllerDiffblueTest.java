package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.service.entitiy.entity.relation.DefaultTbEntityRelationService;

@ExtendWith(MockitoExtension.class)
class EntityRelationControllerDiffblueTest {
  @InjectMocks private EntityRelationController entityRelationController;

  /**
   * Test {@link EntityRelationController#saveRelation(EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationController}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#saveRelation(EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test saveRelation(EntityRelation); given EntityRelationController; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRelationController.saveRelation(EntityRelation)"})
  void testSaveRelation_givenEntityRelationController_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> entityRelationController.saveRelation(relation));
    verify(relation).getFrom();
  }

  /**
   * Test {@link EntityRelationController#saveRelation(EntityRelation)}.
   *
   * <ul>
   *   <li>When {@link EntityRelation#EntityRelation()}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#saveRelation(EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test saveRelation(EntityRelation); when EntityRelation(); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRelationController.saveRelation(EntityRelation)"})
  void testSaveRelation_whenEntityRelation_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());
    EntityRelationController entityRelationController =
        new EntityRelationController(new DefaultTbEntityRelationService(relationService));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> entityRelationController.saveRelation(new EntityRelation()));
  }

  /**
   * Test {@link EntityRelationController#saveRelation(EntityRelation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#saveRelation(EntityRelation)}
   */
  @Test
  @DisplayName("Test saveRelation(EntityRelation); when 'null'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRelationController.saveRelation(EntityRelation)"})
  void testSaveRelation_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .saveRelation(null));
  }

  /**
   * Test {@link EntityRelationController#saveRelationV2(EntityRelation)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#saveRelationV2(EntityRelation)}
   */
  @Test
  @DisplayName("Test saveRelationV2(EntityRelation); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation EntityRelationController.saveRelationV2(EntityRelation)"})
  void testSaveRelationV2_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> entityRelationController.saveRelationV2(relation));
    verify(relation).getFrom();
  }

  /**
   * Test {@link EntityRelationController#saveRelationV2(EntityRelation)}.
   *
   * <ul>
   *   <li>When {@link EntityRelation#EntityRelation()}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#saveRelationV2(EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test saveRelationV2(EntityRelation); when EntityRelation(); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation EntityRelationController.saveRelationV2(EntityRelation)"})
  void testSaveRelationV2_whenEntityRelation_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());
    EntityRelationController entityRelationController =
        new EntityRelationController(new DefaultTbEntityRelationService(relationService));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> entityRelationController.saveRelationV2(new EntityRelation()));
  }

  /**
   * Test {@link EntityRelationController#saveRelationV2(EntityRelation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#saveRelationV2(EntityRelation)}
   */
  @Test
  @DisplayName("Test saveRelationV2(EntityRelation); when 'null'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation EntityRelationController.saveRelationV2(EntityRelation)"})
  void testSaveRelationV2_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .saveRelationV2(null));
  }

  /**
   * Test {@link EntityRelationController#deleteRelation(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelation(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test deleteRelation(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationController.deleteRelation(String, String, String, String, String, String)"
  })
  void testDeleteRelation() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .deleteRelation(
                    "",
                    "jane.doe@example.org",
                    "Str Relation Type",
                    "Str Relation Type Group",
                    "42",
                    "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#deleteRelation(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelation(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test deleteRelation(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationController.deleteRelation(String, String, String, String, String, String)"
  })
  void testDeleteRelation2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .deleteRelation(
                    "42",
                    "jane.doe@example.org",
                    "",
                    "Str Relation Type Group",
                    "42",
                    "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#deleteRelation(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelation(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test deleteRelation(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationController.deleteRelation(String, String, String, String, String, String)"
  })
  void testDeleteRelation3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .deleteRelation(
                    "42",
                    "jane.doe@example.org",
                    "Str Relation Type",
                    "Str Relation Type Group",
                    "",
                    "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#deleteRelation(String, String, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationController}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelation(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test deleteRelation(String, String, String, String, String, String); given EntityRelationController; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationController.deleteRelation(String, String, String, String, String, String)"
  })
  void testDeleteRelation_givenEntityRelationController_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            entityRelationController.deleteRelation(
                "42",
                "jane.doe@example.org",
                "Str Relation Type",
                "Str Relation Type Group",
                "42",
                ""));
  }

  /**
   * Test {@link EntityRelationController#deleteRelationV2(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelationV2(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test deleteRelationV2(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation EntityRelationController.deleteRelationV2(String, String, String, String, String, String)"
  })
  void testDeleteRelationV2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .deleteRelationV2(
                    "",
                    "jane.doe@example.org",
                    "Str Relation Type",
                    "Str Relation Type Group",
                    "42",
                    "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#deleteRelationV2(String, String, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationController}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelationV2(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test deleteRelationV2(String, String, String, String, String, String); given EntityRelationController; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation EntityRelationController.deleteRelationV2(String, String, String, String, String, String)"
  })
  void testDeleteRelationV2_givenEntityRelationController_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            entityRelationController.deleteRelationV2(
                "42",
                "jane.doe@example.org",
                "Str Relation Type",
                "Str Relation Type Group",
                "42",
                ""));
  }

  /**
   * Test {@link EntityRelationController#deleteRelationV2(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelationV2(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test deleteRelationV2(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation EntityRelationController.deleteRelationV2(String, String, String, String, String, String)"
  })
  void testDeleteRelationV22() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .deleteRelationV2(
                    "42",
                    "jane.doe@example.org",
                    "",
                    "Str Relation Type Group",
                    "42",
                    "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#deleteRelationV2(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelationV2(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test deleteRelationV2(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation EntityRelationController.deleteRelationV2(String, String, String, String, String, String)"
  })
  void testDeleteRelationV23() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .deleteRelationV2(
                    "42",
                    "jane.doe@example.org",
                    "Str Relation Type",
                    "Str Relation Type Group",
                    "",
                    "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#deleteRelations(String, String)}.
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelations(String, String)}
   */
  @Test
  @DisplayName("Test deleteRelations(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRelationController.deleteRelations(String, String)"})
  void testDeleteRelations() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .deleteRelations("", "Str Type"));
  }

  /**
   * Test {@link EntityRelationController#deleteRelations(String, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationController}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#deleteRelations(String, String)}
   */
  @Test
  @DisplayName(
      "Test deleteRelations(String, String); given EntityRelationController; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRelationController.deleteRelations(String, String)"})
  void testDeleteRelations_givenEntityRelationController_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class, () -> entityRelationController.deleteRelations("42", ""));
  }

  /**
   * Test {@link EntityRelationController#getRelation(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#getRelation(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getRelation(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation EntityRelationController.getRelation(String, String, String, String, String, String)"
  })
  void testGetRelation() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .getRelation(
                    "",
                    "jane.doe@example.org",
                    "Str Relation Type",
                    "Str Relation Type Group",
                    "42",
                    "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#getRelation(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#getRelation(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getRelation(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation EntityRelationController.getRelation(String, String, String, String, String, String)"
  })
  void testGetRelation2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .getRelation(
                    "42", "", "Str Relation Type", "Str Relation Type Group", "42", "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#getRelation(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#getRelation(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getRelation(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation EntityRelationController.getRelation(String, String, String, String, String, String)"
  })
  void testGetRelation3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .getRelation(
                    "42",
                    "jane.doe@example.org",
                    "",
                    "Str Relation Type Group",
                    "42",
                    "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#getRelation(String, String, String, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntityRelationController#getRelation(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test getRelation(String, String, String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation EntityRelationController.getRelation(String, String, String, String, String, String)"
  })
  void testGetRelation4() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .getRelation(
                    "42",
                    "jane.doe@example.org",
                    "Str Relation Type",
                    "Str Relation Type Group",
                    "",
                    "Str To Type"));
  }

  /**
   * Test {@link EntityRelationController#getRelation(String, String, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationController}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#getRelation(String, String, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getRelation(String, String, String, String, String, String); given EntityRelationController; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation EntityRelationController.getRelation(String, String, String, String, String, String)"
  })
  void testGetRelation_givenEntityRelationController_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            entityRelationController.getRelation(
                "42",
                "jane.doe@example.org",
                "Str Relation Type",
                "Str Relation Type Group",
                "42",
                ""));
  }

  /**
   * Test {@link EntityRelationController#findByFrom(String, String, String)} with {@code
   * strFromId}, {@code strFromType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByFrom(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test findByFrom(String, String, String) with 'strFromId', 'strFromType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByFrom(String, String, String)"})
  void testFindByFromWithStrFromIdStrFromTypeStrRelationTypeGroup() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .findByFrom("", "jane.doe@example.org", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByFrom(String, String, String)} with {@code
   * strFromId}, {@code strFromType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByFrom(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test findByFrom(String, String, String) with 'strFromId', 'strFromType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByFrom(String, String, String)"})
  void testFindByFromWithStrFromIdStrFromTypeStrRelationTypeGroup2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> entityRelationController.findByFrom("42", "", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByFrom(String, String, String, String)} with {@code
   * strFromId}, {@code strFromType}, {@code strRelationType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByFrom(String, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByFrom(String, String, String, String) with 'strFromId', 'strFromType', 'strRelationType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findByFrom(String, String, String, String)"
  })
  void testFindByFromWithStrFromIdStrFromTypeStrRelationTypeStrRelationTypeGroup()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .findByFrom(
                    "", "jane.doe@example.org", "Str Relation Type", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByFrom(String, String, String, String)} with {@code
   * strFromId}, {@code strFromType}, {@code strRelationType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByFrom(String, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByFrom(String, String, String, String) with 'strFromId', 'strFromType', 'strRelationType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findByFrom(String, String, String, String)"
  })
  void testFindByFromWithStrFromIdStrFromTypeStrRelationTypeStrRelationTypeGroup2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .findByFrom("42", "", "Str Relation Type", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByFrom(String, String, String, String)} with {@code
   * strFromId}, {@code strFromType}, {@code strRelationType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByFrom(String, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findByFrom(String, String, String, String) with 'strFromId', 'strFromType', 'strRelationType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findByFrom(String, String, String, String)"
  })
  void testFindByFromWithStrFromIdStrFromTypeStrRelationTypeStrRelationTypeGroup3()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            entityRelationController.findByFrom(
                "42", "jane.doe@example.org", "", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findInfoByFrom(String, String, String)}.
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByFrom(String, String, String)}
   */
  @Test
  @DisplayName("Test findInfoByFrom(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByFrom(String, String, String)"
  })
  void testFindInfoByFrom() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .findInfoByFrom("", "jane.doe@example.org", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findInfoByFrom(String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationController}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByFrom(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test findInfoByFrom(String, String, String); given EntityRelationController; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByFrom(String, String, String)"
  })
  void testFindInfoByFrom_givenEntityRelationController_thenThrowThingsboardException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> entityRelationController.findInfoByFrom("42", "", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByTo(String, String, String)} with {@code strToId},
   * {@code strToType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByTo(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test findByTo(String, String, String) with 'strToId', 'strToType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByTo(String, String, String)"})
  void testFindByToWithStrToIdStrToTypeStrRelationTypeGroup() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .findByTo("", "Str To Type", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByTo(String, String, String)} with {@code strToId},
   * {@code strToType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByTo(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test findByTo(String, String, String) with 'strToId', 'strToType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByTo(String, String, String)"})
  void testFindByToWithStrToIdStrToTypeStrRelationTypeGroup2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> entityRelationController.findByTo("42", "", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByTo(String, String, String, String)} with {@code
   * strToId}, {@code strToType}, {@code strRelationType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByTo(String, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test findByTo(String, String, String, String) with 'strToId', 'strToType', 'strRelationType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findByTo(String, String, String, String)"
  })
  void testFindByToWithStrToIdStrToTypeStrRelationTypeStrRelationTypeGroup()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .findByTo("", "Str To Type", "Str Relation Type", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByTo(String, String, String, String)} with {@code
   * strToId}, {@code strToType}, {@code strRelationType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByTo(String, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test findByTo(String, String, String, String) with 'strToId', 'strToType', 'strRelationType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findByTo(String, String, String, String)"
  })
  void testFindByToWithStrToIdStrToTypeStrRelationTypeStrRelationTypeGroup2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .findByTo("42", "", "Str Relation Type", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByTo(String, String, String, String)} with {@code
   * strToId}, {@code strToType}, {@code strRelationType}, {@code strRelationTypeGroup}.
   *
   * <p>Method under test: {@link EntityRelationController#findByTo(String, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test findByTo(String, String, String, String) with 'strToId', 'strToType', 'strRelationType', 'strRelationTypeGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findByTo(String, String, String, String)"
  })
  void testFindByToWithStrToIdStrToTypeStrRelationTypeStrRelationTypeGroup3()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            entityRelationController.findByTo("42", "Str To Type", "", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findInfoByTo(String, String, String)}.
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByTo(String, String, String)}
   */
  @Test
  @DisplayName("Test findInfoByTo(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByTo(String, String, String)"
  })
  void testFindInfoByTo() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService relationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntityRelationController(new DefaultTbEntityRelationService(relationService))
                .findInfoByTo("", "Str To Type", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findInfoByTo(String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationController}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByTo(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test findInfoByTo(String, String, String); given EntityRelationController; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByTo(String, String, String)"
  })
  void testFindInfoByTo_givenEntityRelationController_thenThrowThingsboardException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> entityRelationController.findInfoByTo("42", "", "Str Relation Type Group"));
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityRelationsQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters parameters =
        new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findByQuery(query));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code RULE_NODE}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityRelationsQuery); given AlarmId getEntityType() return 'RULE_NODE'; then calls getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery_givenAlarmIdGetEntityTypeReturnRuleNode_thenCallsGetEntityType()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code TENANT_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityRelationsQuery); given AlarmId getEntityType() return 'TENANT_PROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery_givenAlarmIdGetEntityTypeReturnTenantProfile()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityRelationsQuery); given AlarmId getEntityType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery_givenAlarmIdGetEntityTypeThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} return {@code null}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityRelationsQuery); given AlarmId getId() return 'null'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery_givenAlarmIdGetIdReturnNull_thenCallsGetId()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(null);

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findByQuery(query));
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} return randomUUID.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityRelationsQuery); given AlarmId getId() return randomUUID; then calls getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery_givenAlarmIdGetIdReturnRandomUUID_thenCallsGetEntityType()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityRelationsQuery); given AlarmId getId() throw IllegalArgumentException(); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery_givenAlarmIdGetIdThrowIllegalArgumentException_thenCallsGetId()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IllegalArgumentException());

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findByQuery(query));
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntityRelationsQuery} (default constructor) Parameters is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityRelationsQuery); given 'null'; when EntityRelationsQuery (default constructor) Parameters is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery_givenNull_whenEntityRelationsQueryParametersIsNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(null);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findByQuery(query));
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link RelationsSearchParameters} {@link RelationsSearchParameters#getEntityId()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(EntityRelationsQuery); given RelationsSearchParameters getEntityId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery_givenRelationsSearchParametersGetEntityIdReturnNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(null);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findByQuery(query));
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(EntityRelationsQuery); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List EntityRelationController.findByQuery(EntityRelationsQuery)"})
  void testFindByQuery_thenThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenThrow(new IllegalArgumentException());

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityRelationController.findByQuery(query));
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName("Test findInfoByQuery(EntityRelationsQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters parameters =
        new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findInfoByQuery(query));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code RULE_NODE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findInfoByQuery(EntityRelationsQuery); given AlarmId getEntityType() return 'RULE_NODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery_givenAlarmIdGetEntityTypeReturnRuleNode()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.RULE_NODE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findInfoByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code TENANT_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findInfoByQuery(EntityRelationsQuery); given AlarmId getEntityType() return 'TENANT_PROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery_givenAlarmIdGetEntityTypeReturnTenantProfile()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT_PROFILE);
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findInfoByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findInfoByQuery(EntityRelationsQuery); given AlarmId getEntityType() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery_givenAlarmIdGetEntityTypeThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findInfoByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} return {@code null}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findInfoByQuery(EntityRelationsQuery); given AlarmId getId() return 'null'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery_givenAlarmIdGetIdReturnNull_thenCallsGetId()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(null);

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findInfoByQuery(query));
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} return randomUUID.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findInfoByQuery(EntityRelationsQuery); given AlarmId getId() return randomUUID; then calls getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery_givenAlarmIdGetIdReturnRandomUUID_thenCallsGetEntityType()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findInfoByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findInfoByQuery(EntityRelationsQuery); given AlarmId getId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery_givenAlarmIdGetIdThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IllegalArgumentException());

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findInfoByQuery(query));
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntityRelationsQuery} (default constructor) Parameters is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findInfoByQuery(EntityRelationsQuery); given 'null'; when EntityRelationsQuery (default constructor) Parameters is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery_givenNull_whenEntityRelationsQueryParametersIsNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(null);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findInfoByQuery(query));
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link RelationsSearchParameters} {@link RelationsSearchParameters#getEntityId()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findInfoByQuery(EntityRelationsQuery); given RelationsSearchParameters getEntityId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery_givenRelationsSearchParametersGetEntityIdReturnNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(null);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> entityRelationController.findInfoByQuery(query));
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationController#findInfoByQuery(EntityRelationsQuery)}
   */
  @Test
  @DisplayName("Test findInfoByQuery(EntityRelationsQuery); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List EntityRelationController.findInfoByQuery(EntityRelationsQuery)"
  })
  void testFindInfoByQuery_thenThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenThrow(new IllegalArgumentException());

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> entityRelationController.findInfoByQuery(query));
    verify(parameters).getEntityId();
  }
}
