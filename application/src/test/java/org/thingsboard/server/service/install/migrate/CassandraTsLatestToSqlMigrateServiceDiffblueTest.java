package org.thingsboard.server.service.install.migrate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.Optional;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryCompositeKey;
import org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryEntry;
import org.thingsboard.server.dao.sqlts.dictionary.KeyDictionaryRepository;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class CassandraTsLatestToSqlMigrateServiceDiffblueTest {
  @InjectMocks private CassandraTsLatestToSqlMigrateService cassandraTsLatestToSqlMigrateService;

  @Mock private KeyDictionaryRepository keyDictionaryRepository;

  /**
   * Test {@link CassandraTsLatestToSqlMigrateService#getOrSaveKeyId(String)}.
   *
   * <p>Method under test: {@link CassandraTsLatestToSqlMigrateService#getOrSaveKeyId(String)}
   */
  @Test
  @DisplayName("Test getOrSaveKeyId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer CassandraTsLatestToSqlMigrateService.getOrSaveKeyId(String)"})
  void testGetOrSaveKeyId() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);
    Optional<KeyDictionaryEntry> ofResult = Optional.of(keyDictionaryEntry);
    when(keyDictionaryRepository.findById(Mockito.<KeyDictionaryCompositeKey>any()))
        .thenReturn(ofResult);

    // Act
    Integer actualOrSaveKeyId = cassandraTsLatestToSqlMigrateService.getOrSaveKeyId("Str Key");

    // Assert
    verify(keyDictionaryRepository).findById(isA(KeyDictionaryCompositeKey.class));
    assertEquals(1, actualOrSaveKeyId.intValue());
  }

  /**
   * Test {@link CassandraTsLatestToSqlMigrateService#getOrSaveKeyId(String)}.
   *
   * <ul>
   *   <li>Given {@link KeyDictionaryRepository} {@link KeyDictionaryRepository#findById(Object)}
   *       return empty.
   *   <li>Then calls {@link KeyDictionaryRepository#save(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraTsLatestToSqlMigrateService#getOrSaveKeyId(String)}
   */
  @Test
  @DisplayName(
      "Test getOrSaveKeyId(String); given KeyDictionaryRepository findById(Object) return empty; then calls save(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer CassandraTsLatestToSqlMigrateService.getOrSaveKeyId(String)"})
  void testGetOrSaveKeyId_givenKeyDictionaryRepositoryFindByIdReturnEmpty_thenCallsSave() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);
    when(keyDictionaryRepository.save(Mockito.<KeyDictionaryEntry>any()))
        .thenReturn(keyDictionaryEntry);
    Optional<KeyDictionaryEntry> emptyResult = Optional.empty();
    when(keyDictionaryRepository.findById(Mockito.<KeyDictionaryCompositeKey>any()))
        .thenReturn(emptyResult);

    // Act
    Integer actualOrSaveKeyId = cassandraTsLatestToSqlMigrateService.getOrSaveKeyId("Str Key");

    // Assert
    verify(keyDictionaryRepository, atLeast(1)).findById(isA(KeyDictionaryCompositeKey.class));
    verify(keyDictionaryRepository).save(isA(KeyDictionaryEntry.class));
    assertEquals(1, actualOrSaveKeyId.intValue());
  }

  /**
   * Test {@link CassandraTsLatestToSqlMigrateService#getOrSaveKeyId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraTsLatestToSqlMigrateService#getOrSaveKeyId(String)}
   */
  @Test
  @DisplayName("Test getOrSaveKeyId(String); then throw ConstraintViolationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer CassandraTsLatestToSqlMigrateService.getOrSaveKeyId(String)"})
  void testGetOrSaveKeyId_thenThrowConstraintViolationException() {
    // Arrange
    when(keyDictionaryRepository.findById(Mockito.<KeyDictionaryCompositeKey>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> cassandraTsLatestToSqlMigrateService.getOrSaveKeyId("Str Key"));
    verify(keyDictionaryRepository).findById(isA(KeyDictionaryCompositeKey.class));
  }
}
