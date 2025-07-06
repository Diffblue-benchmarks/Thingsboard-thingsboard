package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.device.DeviceProfileDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.ota.OtaPackageDao;

@ContextConfiguration(classes = {OtaPackageDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseOtaPackageDataValidatorDiffblueTest {
  @Autowired private BaseOtaPackageDataValidator<OtaPackage> baseOtaPackageDataValidator;

  @MockBean private DeviceProfileDao deviceProfileDao;

  @MockBean private OtaPackageDao otaPackageDao;

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Given {@code Dr}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseOtaPackageDataValidator.validateImpl(OtaPackageInfo)"})
  public void testValidateImpl_givenDr_thenThrowDataValidationException() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo, OtaPackageInfo)} with
   * {@code otaPackage}, {@code otaPackageOld}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo,
   * OtaPackageInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BaseOtaPackageDataValidator.validateUpdate(OtaPackageInfo, OtaPackageInfo)"
  })
  public void testValidateUpdateWithOtaPackageOtaPackageOld_thenThrowDataValidationException() {
    // Arrange
    OtaPackageInfo otaPackage = new OtaPackageInfo();

    OtaPackageInfo otaPackageOld = new OtaPackageInfo();
    otaPackageOld.setType(OtaPackageType.FIRMWARE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateUpdate(otaPackage, otaPackageOld));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo, OtaPackageInfo)} with
   * {@code otaPackage}, {@code otaPackageOld}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo,
   * OtaPackageInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BaseOtaPackageDataValidator.validateUpdate(OtaPackageInfo, OtaPackageInfo)"
  })
  public void testValidateUpdateWithOtaPackageOtaPackageOld_thenThrowDataValidationException2() {
    // Arrange
    OtaPackageInfo otaPackage = new OtaPackageInfo();
    otaPackage.setType(OtaPackageType.FIRMWARE);

    OtaPackageInfo otaPackageOld = new OtaPackageInfo();
    otaPackageOld.setTitle("Dr");
    otaPackageOld.setType(OtaPackageType.FIRMWARE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateUpdate(otaPackage, otaPackageOld));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#getDeviceProfileDao()}.
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#getDeviceProfileDao()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceProfileDao BaseOtaPackageDataValidator.getDeviceProfileDao()"})
  public void testGetDeviceProfileDao() {
    // Arrange, Act and Assert
    assertNull(new OtaPackageDataValidator().getDeviceProfileDao());
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#getTenantService()}.
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#getTenantService()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.thingsboard.server.dao.tenant.TenantService BaseOtaPackageDataValidator.getTenantService()"
  })
  public void testGetTenantService() {
    // Arrange, Act and Assert
    assertNull(new OtaPackageDataValidator().getTenantService());
  }
}
