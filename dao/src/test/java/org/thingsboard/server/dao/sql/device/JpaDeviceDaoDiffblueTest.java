package org.thingsboard.server.dao.sql.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DeviceEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDeviceDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaDeviceDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private DeviceProfileRepository deviceProfileRepository;

  @MockBean
  private DeviceRepository deviceRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaDeviceDao jpaDeviceDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private NativeDeviceRepository nativeDeviceRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaDeviceDao#getEntityClass()}
   *   <li>{@link JpaDeviceDao#getEntityType()}
   *   <li>{@link JpaDeviceDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaDeviceDao.getEntityClass()", "EntityType JpaDeviceDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaDeviceDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaDeviceDao jpaDeviceDao = new JpaDeviceDao();

    // Act
    Class<DeviceEntity> actualEntityClass = jpaDeviceDao.getEntityClass();
    EntityType actualEntityType = jpaDeviceDao.getEntityType();

    // Assert
    assertNull(jpaDeviceDao.getRepository());
    assertEquals(EntityType.DEVICE, actualEntityType);
    Class<DeviceEntity> expectedEntityClass = DeviceEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)}.
   * <p>
   * Method under test: {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long JpaDeviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)"})
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage() {
    // Arrange
    when(
        deviceRepository.countByTenantIdAndDeviceProfileIdAndFirmwareIdIsNull(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(1L);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    Long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult = jpaDeviceDao
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(tenantId,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), OtaPackageType.FIRMWARE);

    // Assert
    verify(deviceRepository).countByTenantIdAndDeviceProfileIdAndFirmwareIdIsNull(isA(UUID.class), isA(UUID.class));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult.longValue());
  }

  /**
   * Test {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)}.
   * <p>
   * Method under test: {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long JpaDeviceDao.countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)"})
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage2() {
    // Arrange
    when(
        deviceRepository.countByTenantIdAndDeviceProfileIdAndSoftwareIdIsNull(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(1L);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    Long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult = jpaDeviceDao
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(tenantId,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), OtaPackageType.SOFTWARE);

    // Assert
    verify(deviceRepository).countByTenantIdAndDeviceProfileIdAndSoftwareIdIsNull(isA(UUID.class), isA(UUID.class));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult.longValue());
  }

  /**
   * Test {@link JpaDeviceDao#countDevicesByDeviceProfileId(TenantId, UUID)}.
   * <p>
   * Method under test: {@link JpaDeviceDao#countDevicesByDeviceProfileId(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long JpaDeviceDao.countDevicesByDeviceProfileId(TenantId, UUID)"})
  public void testCountDevicesByDeviceProfileId() {
    // Arrange
    when(deviceRepository.countByDeviceProfileId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountDevicesByDeviceProfileIdResult = jpaDeviceDao.countDevicesByDeviceProfileId(
        ModelConstants.SYSTEM_TENANT, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(deviceRepository).countByDeviceProfileId(isA(UUID.class));
    assertEquals(1L, actualCountDevicesByDeviceProfileIdResult.longValue());
  }

  /**
   * Test {@link JpaDeviceDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long JpaDeviceDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(deviceRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaDeviceDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }
}
