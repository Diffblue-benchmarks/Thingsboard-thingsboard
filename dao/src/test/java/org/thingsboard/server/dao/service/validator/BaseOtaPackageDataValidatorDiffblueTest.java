package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BaseOtaPackageDataValidatorDiffblueTest {
  /**
   * Test {@link BaseOtaPackageDataValidator#getDeviceProfileDao()}.
   * <p>
   * Method under test: {@link BaseOtaPackageDataValidator#getDeviceProfileDao()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.thingsboard.server.dao.device.DeviceProfileDao BaseOtaPackageDataValidator.getDeviceProfileDao()"})
  public void testGetDeviceProfileDao() {
    // Arrange, Act and Assert
    assertNull((new OtaPackageDataValidator()).getDeviceProfileDao());
  }
}
