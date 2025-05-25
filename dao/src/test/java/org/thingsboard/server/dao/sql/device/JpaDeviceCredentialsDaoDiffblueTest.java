package org.thingsboard.server.dao.sql.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
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
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DeviceCredentialsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDeviceCredentialsDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaDeviceCredentialsDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private DeviceCredentialsRepository deviceCredentialsRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaDeviceCredentialsDao jpaDeviceCredentialsDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaDeviceCredentialsDao#getEntityClass()}
   *   <li>{@link JpaDeviceCredentialsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaDeviceCredentialsDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaDeviceCredentialsDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaDeviceCredentialsDao jpaDeviceCredentialsDao = new JpaDeviceCredentialsDao();

    // Act
    Class<DeviceCredentialsEntity> actualEntityClass = jpaDeviceCredentialsDao.getEntityClass();

    // Assert
    assertNull(jpaDeviceCredentialsDao.getRepository());
    Class<DeviceCredentialsEntity> expectedEntityClass = DeviceCredentialsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDeviceCredentialsDao#findByDeviceId(TenantId, UUID)}.
   * <p>
   * Method under test: {@link JpaDeviceCredentialsDao#findByDeviceId(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials JpaDeviceCredentialsDao.findByDeviceId(TenantId, UUID)"})
  public void testFindByDeviceId() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceCredentialsEntity.setDeviceId(deviceId);
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceCredentialsEntity.setUuid(id);
    deviceCredentialsEntity.setVersion(1L);
    when(deviceCredentialsRepository.findByDeviceId(Mockito.<UUID>any())).thenReturn(deviceCredentialsEntity);

    // Act
    DeviceCredentials actualFindByDeviceIdResult = jpaDeviceCredentialsDao.findByDeviceId(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(deviceCredentialsRepository).findByDeviceId(isA(UUID.class));
    assertEquals("42", actualFindByDeviceIdResult.getCredentialsId());
    assertEquals("42", actualFindByDeviceIdResult.getCredentialsValue());
    assertEquals(1L, actualFindByDeviceIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByDeviceIdResult.getCreatedTime());
    DeviceId deviceId2 = actualFindByDeviceIdResult.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualFindByDeviceIdResult.getCredentialsType());
    assertFalse(deviceId2.isNullUid());
    assertSame(id, actualFindByDeviceIdResult.getUuidId());
    assertSame(deviceId, deviceId2.getId());
    assertSame(id, actualFindByDeviceIdResult.getId().getId());
  }

  /**
   * Test {@link JpaDeviceCredentialsDao#findByCredentialsId(TenantId, String)}.
   * <p>
   * Method under test: {@link JpaDeviceCredentialsDao#findByCredentialsId(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials JpaDeviceCredentialsDao.findByCredentialsId(TenantId, String)"})
  public void testFindByCredentialsId() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceCredentialsEntity.setDeviceId(deviceId);
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceCredentialsEntity.setUuid(id);
    deviceCredentialsEntity.setVersion(1L);
    when(deviceCredentialsRepository.findByCredentialsId(Mockito.<String>any())).thenReturn(deviceCredentialsEntity);

    // Act
    DeviceCredentials actualFindByCredentialsIdResult = jpaDeviceCredentialsDao
        .findByCredentialsId(ModelConstants.SYSTEM_TENANT, "42");

    // Assert
    verify(deviceCredentialsRepository).findByCredentialsId(eq("42"));
    assertEquals("42", actualFindByCredentialsIdResult.getCredentialsId());
    assertEquals("42", actualFindByCredentialsIdResult.getCredentialsValue());
    UUID uuidId = actualFindByCredentialsIdResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    DeviceId deviceId2 = actualFindByCredentialsIdResult.getDeviceId();
    UUID id2 = deviceId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(1L, actualFindByCredentialsIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByCredentialsIdResult.getCreatedTime());
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualFindByCredentialsIdResult.getCredentialsType());
    assertFalse(deviceId2.isNullUid());
    assertSame(id, uuidId);
    assertSame(deviceId, id2);
    assertSame(id, actualFindByCredentialsIdResult.getId().getId());
  }

  /**
   * Test {@link JpaDeviceCredentialsDao#removeByDeviceId(TenantId, DeviceId)}.
   * <p>
   * Method under test: {@link JpaDeviceCredentialsDao#removeByDeviceId(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials JpaDeviceCredentialsDao.removeByDeviceId(TenantId, DeviceId)"})
  public void testRemoveByDeviceId() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceCredentialsEntity.setDeviceId(deviceId);
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setVersion(1L);
    when(deviceCredentialsRepository.deleteByDeviceId(Mockito.<UUID>any())).thenReturn(deviceCredentialsEntity);
    DeviceId deviceId2 = mock(DeviceId.class);
    when(deviceId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DeviceCredentials actualRemoveByDeviceIdResult = jpaDeviceCredentialsDao
        .removeByDeviceId(ModelConstants.SYSTEM_TENANT, deviceId2);

    // Assert
    verify(deviceId2).getId();
    verify(deviceCredentialsRepository).deleteByDeviceId(isA(UUID.class));
    DeviceId deviceId3 = actualRemoveByDeviceIdResult.getDeviceId();
    UUID id = deviceId3.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DEVICE, deviceId3.getEntityType());
    assertFalse(deviceId3.isNullUid());
    assertSame(deviceId, id);
  }

  /**
   * Test {@link JpaDeviceCredentialsDao#removeByDeviceId(TenantId, DeviceId)}.
   * <ul>
   *   <li>Then return CredentialsId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceCredentialsDao#removeByDeviceId(TenantId, DeviceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials JpaDeviceCredentialsDao.removeByDeviceId(TenantId, DeviceId)"})
  public void testRemoveByDeviceId_thenReturnCredentialsIdIs42() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceCredentialsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    deviceCredentialsEntity.setUuid(id);
    deviceCredentialsEntity.setVersion(1L);
    when(deviceCredentialsRepository.deleteByDeviceId(Mockito.<UUID>any())).thenReturn(deviceCredentialsEntity);
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DeviceCredentials actualRemoveByDeviceIdResult = jpaDeviceCredentialsDao
        .removeByDeviceId(ModelConstants.SYSTEM_TENANT, deviceId);

    // Assert
    verify(deviceCredentialsRepository).deleteByDeviceId(isA(UUID.class));
    assertEquals("42", actualRemoveByDeviceIdResult.getCredentialsId());
    assertEquals("42", actualRemoveByDeviceIdResult.getCredentialsValue());
    UUID uuidId = actualRemoveByDeviceIdResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals(1L, actualRemoveByDeviceIdResult.getVersion().longValue());
    assertEquals(1L, actualRemoveByDeviceIdResult.getCreatedTime());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualRemoveByDeviceIdResult.getCredentialsType());
    assertEquals(deviceId, actualRemoveByDeviceIdResult.getDeviceId());
    assertSame(id, uuidId);
    assertSame(id, actualRemoveByDeviceIdResult.getId().getId());
  }
}
