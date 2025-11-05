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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetSearchQuery;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.service.asset.AssetBulkImportService;
import org.thingsboard.server.service.entitiy.asset.DefaultTbAssetService;

@ExtendWith(MockitoExtension.class)
class AssetControllerDiffblueTest {
  @InjectMocks private AssetController assetController;

  /**
   * Test {@link AssetController#deleteAsset(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#deleteAsset(String)}
   */
  @Test
  @DisplayName("Test deleteAsset(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetController.deleteAsset(String)"})
  void testDeleteAsset_when42() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.deleteAsset("42"));
  }

  /**
   * Test {@link AssetController#deleteAsset(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#deleteAsset(String)}
   */
  @Test
  @DisplayName("Test deleteAsset(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetController.deleteAsset(String)"})
  void testDeleteAsset_whenEmptyString() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.deleteAsset(""));
  }

  /**
   * Test {@link AssetController#assignAssetToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#assignAssetToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignAssetToCustomer(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.asset.Asset AssetController.assignAssetToCustomer(String, String)"
  })
  void testAssignAssetToCustomer_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetController.assignAssetToCustomer("42", "42"));
  }

  /**
   * Test {@link AssetController#assignAssetToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#assignAssetToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignAssetToCustomer(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.asset.Asset AssetController.assignAssetToCustomer(String, String)"
  })
  void testAssignAssetToCustomer_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.assignAssetToCustomer("", "42"));
  }

  /**
   * Test {@link AssetController#assignAssetToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#assignAssetToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignAssetToCustomer(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.asset.Asset AssetController.assignAssetToCustomer(String, String)"
  })
  void testAssignAssetToCustomer_whenEmptyString2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.assignAssetToCustomer("42", ""));
  }

  /**
   * Test {@link AssetController#assignAssetToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#assignAssetToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignAssetToPublicCustomer(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.asset.Asset AssetController.assignAssetToPublicCustomer(String)"
  })
  void testAssignAssetToPublicCustomer_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetController.assignAssetToPublicCustomer("42"));
  }

  /**
   * Test {@link AssetController#assignAssetToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#assignAssetToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignAssetToPublicCustomer(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.asset.Asset AssetController.assignAssetToPublicCustomer(String)"
  })
  void testAssignAssetToPublicCustomer_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.assignAssetToPublicCustomer(""));
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters =
        new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);
    parameters.setRootType(EntityType.TENANT);

    AssetSearchQuery query = new AssetSearchQuery();
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.findByQuery(query));
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery2() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Requested item wasn't found!");

    AssetSearchQuery query = new AssetSearchQuery();
    query.setAssetTypes(assetTypes);
    query.setParameters(
        new RelationsSearchParameters(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EntityType.TENANT,
            EntitySearchDirection.FROM,
            RelationTypeGroup.COMMON,
            3,
            true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.findByQuery(query));
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery3() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Requested item wasn't found!");

    AssetSearchQuery query = new AssetSearchQuery();
    query.setAssetTypes(assetTypes);
    query.setParameters(
        new RelationsSearchParameters(
            null,
            EntityType.TENANT,
            EntitySearchDirection.FROM,
            RelationTypeGroup.COMMON,
            3,
            true));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.findByQuery(query));
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery4() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Requested item wasn't found!");

    AssetSearchQuery query = new AssetSearchQuery();
    query.setAssetTypes(assetTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> assetController.findByQuery(query));
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery5() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Requested item wasn't found!");

    AssetSearchQuery query = new AssetSearchQuery();
    query.setAssetTypes(assetTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.findByQuery(query));
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery6() throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(alarmId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(alarmId);

    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Requested item wasn't found!");

    AssetSearchQuery query = new AssetSearchQuery();
    query.setAssetTypes(assetTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code RULE_NODE}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(AssetSearchQuery); given AlarmId getEntityType() return 'RULE_NODE'; then calls getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
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

    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Requested item wasn't found!");

    AssetSearchQuery query = new AssetSearchQuery();
    query.setAssetTypes(assetTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId} {@link AlarmId#getEntityType()} return {@code TENANT_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(AssetSearchQuery); given AlarmId getEntityType() return 'TENANT_PROFILE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
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

    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Requested item wasn't found!");

    AssetSearchQuery query = new AssetSearchQuery();
    query.setAssetTypes(assetTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.findByQuery(query));
    verify(alarmId).getEntityType();
    verify(alarmId, atLeast(1)).getId();
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link RelationsSearchParameters} {@link RelationsSearchParameters#getEntityId()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findByQuery(AssetSearchQuery); given RelationsSearchParameters getEntityId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery_givenRelationsSearchParametersGetEntityIdReturnNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RelationsSearchParameters parameters = mock(RelationsSearchParameters.class);
    when(parameters.getEntityId()).thenReturn(null);

    ArrayList<String> assetTypes = new ArrayList<>();
    assetTypes.add("Requested item wasn't found!");

    AssetSearchQuery query = new AssetSearchQuery();
    query.setAssetTypes(assetTypes);
    query.setParameters(parameters);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.findByQuery(query));
    verify(parameters).getEntityId();
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link AssetSearchQuery#getParameters()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery); then calls getParameters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery_thenCallsGetParameters()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    AssetSearchQuery query = mock(AssetSearchQuery.class);
    when(query.getParameters()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> assetController.findByQuery(query));
    verify(query).getParameters();
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <ul>
   *   <li>When {@link AssetSearchQuery} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery); when AssetSearchQuery (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery_whenAssetSearchQuery()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetController.findByQuery(new AssetSearchQuery()));
  }

  /**
   * Test {@link AssetController#findByQuery(AssetSearchQuery)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#findByQuery(AssetSearchQuery)}
   */
  @Test
  @DisplayName("Test findByQuery(AssetSearchQuery); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetController.findByQuery(AssetSearchQuery)"})
  void testFindByQuery_whenNull()
      throws InterruptedException, ExecutionException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.findByQuery(null));
  }

  /**
   * Test {@link AssetController#assignAssetToEdge(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#assignAssetToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignAssetToEdge(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.asset.Asset AssetController.assignAssetToEdge(String, String)"
  })
  void testAssignAssetToEdge_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.assignAssetToEdge("42", "42"));
  }

  /**
   * Test {@link AssetController#assignAssetToEdge(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#assignAssetToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignAssetToEdge(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.asset.Asset AssetController.assignAssetToEdge(String, String)"
  })
  void testAssignAssetToEdge_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.assignAssetToEdge("", "42"));
  }

  /**
   * Test {@link AssetController#assignAssetToEdge(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetController#assignAssetToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignAssetToEdge(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.asset.Asset AssetController.assignAssetToEdge(String, String)"
  })
  void testAssignAssetToEdge_whenEmptyString2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());
    AssetController assetController =
        new AssetController(
            assetBulkImportService, new DefaultTbAssetService(new BaseAssetService()));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetController.assignAssetToEdge("42", ""));
  }
}
