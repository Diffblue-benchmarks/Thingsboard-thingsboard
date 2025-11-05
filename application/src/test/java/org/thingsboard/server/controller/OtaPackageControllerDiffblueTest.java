package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.ota.BaseOtaPackageService;
import org.thingsboard.server.dao.service.validator.OtaPackageDataValidator;
import org.thingsboard.server.dao.service.validator.OtaPackageInfoDataValidator;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageDao;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageInfoDao;
import org.thingsboard.server.service.entitiy.ota.DefaultTbOtaPackageService;

class OtaPackageControllerDiffblueTest {
  /**
   * Test {@link OtaPackageController#downloadOtaPackage(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageController#downloadOtaPackage(String)}
   */
  @Test
  @DisplayName("Test downloadOtaPackage(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity OtaPackageController.downloadOtaPackage(String)"
  })
  void testDownloadOtaPackage_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService otaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new OtaPackageController(new DefaultTbOtaPackageService(otaPackageService))
                .downloadOtaPackage("42"));
  }

  /**
   * Test {@link OtaPackageController#downloadOtaPackage(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageController#downloadOtaPackage(String)}
   */
  @Test
  @DisplayName("Test downloadOtaPackage(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.http.ResponseEntity OtaPackageController.downloadOtaPackage(String)"
  })
  void testDownloadOtaPackage_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService otaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new OtaPackageController(new DefaultTbOtaPackageService(otaPackageService))
                .downloadOtaPackage(""));
  }

  /**
   * Test {@link OtaPackageController#deleteOtaPackage(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageController#deleteOtaPackage(String)}
   */
  @Test
  @DisplayName("Test deleteOtaPackage(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageController.deleteOtaPackage(String)"})
  void testDeleteOtaPackage_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService otaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new OtaPackageController(new DefaultTbOtaPackageService(otaPackageService))
                .deleteOtaPackage("42"));
  }

  /**
   * Test {@link OtaPackageController#deleteOtaPackage(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageController#deleteOtaPackage(String)}
   */
  @Test
  @DisplayName("Test deleteOtaPackage(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageController.deleteOtaPackage(String)"})
  void testDeleteOtaPackage_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService otaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new OtaPackageController(new DefaultTbOtaPackageService(otaPackageService))
                .deleteOtaPackage(""));
  }
}
