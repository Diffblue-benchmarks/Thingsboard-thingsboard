package org.thingsboard.server.dao.sql.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantInfo;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TenantEntity;
import org.thingsboard.server.dao.model.sql.TenantInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTenantDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTenantDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaTenantDao jpaTenantDao;

  @MockBean
  private TenantRepository tenantRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaTenantDao#getEntityClass()}
   *   <li>{@link JpaTenantDao#getEntityType()}
   *   <li>{@link JpaTenantDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaTenantDao.getEntityClass()", "EntityType JpaTenantDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaTenantDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaTenantDao jpaTenantDao = new JpaTenantDao();

    // Act
    Class<TenantEntity> actualEntityClass = jpaTenantDao.getEntityClass();
    EntityType actualEntityType = jpaTenantDao.getEntityType();

    // Assert
    assertNull(jpaTenantDao.getRepository());
    assertEquals(EntityType.TENANT, actualEntityType);
    Class<TenantEntity> expectedEntityClass = TenantEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantInfo JpaTenantDao.findTenantInfoById(TenantId, UUID)"})
  public void testFindTenantInfoById_thenAdditionalInfoReturnNullNode() {
    // Arrange
    when(tenantRepository.findTenantInfoById(Mockito.<UUID>any())).thenReturn(new TenantInfoEntity());

    // Act
    TenantInfo actualFindTenantInfoByIdResult = jpaTenantDao.findTenantInfoById(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(tenantRepository).findTenantInfoById(isA(UUID.class));
    JsonNode additionalInfo = actualFindTenantInfoByIdResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualFindTenantInfoByIdResult.getId().getId());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnEmpty() {
    // Arrange
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertTrue(actualFindTenantIdsByTenantProfileIdResult.isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnEmpty2() {
    // Arrange
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(tenantProfileId);

    // Assert
    verify(tenantProfileId).getId();
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertTrue(actualFindTenantIdsByTenantProfileIdResult.isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return first Id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnFirstIdIsRandomUUID() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    UUID randomUUIDResult = UUID.randomUUID();
    uuidList.add(randomUUIDResult);
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(uuidList);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(tenantProfileId);

    // Assert
    verify(tenantProfileId).getId();
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertEquals(1, actualFindTenantIdsByTenantProfileIdResult.size());
    TenantId getResult = actualFindTenantIdsByTenantProfileIdResult.get(0);
    assertEquals(EntityType.TENANT, getResult.getEntityType());
    assertFalse(getResult.isNullUid());
    assertFalse(getResult.isSysTenantId());
    assertSame(randomUUIDResult, getResult.getId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(uuidList);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertEquals(1, actualFindTenantIdsByTenantProfileIdResult.size());
    TenantId getResult = actualFindTenantIdsByTenantProfileIdResult.get(0);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.getId().toString());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
    assertFalse(getResult.isNullUid());
    assertFalse(getResult.isSysTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaTenantDao.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    uuidList.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(uuidList);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertEquals(2, actualFindTenantIdsByTenantProfileIdResult.size());
    TenantId getResult = actualFindTenantIdsByTenantProfileIdResult.get(0);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.getId().toString());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
    assertFalse(getResult.isNullUid());
    assertFalse(getResult.isSysTenantId());
    assertSame(getResult, actualFindTenantIdsByTenantProfileIdResult.get(1));
  }
}
