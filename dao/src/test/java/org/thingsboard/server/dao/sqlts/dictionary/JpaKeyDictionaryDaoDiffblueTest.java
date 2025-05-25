package org.thingsboard.server.dao.sqlts.dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryCompositeKey;
import org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryEntry;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaKeyDictionaryDao.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaKeyDictionaryDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaKeyDictionaryDao jpaKeyDictionaryDao;

  @MockBean
  private KeyDictionaryRepository keyDictionaryRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaKeyDictionaryDao#getOrSaveKeyId(String)}.
   * <ul>
   *   <li>Given {@link KeyDictionaryRepository} {@link CrudRepository#findById(Object)} return empty.</li>
   *   <li>Then calls {@link CrudRepository#save(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaKeyDictionaryDao#getOrSaveKeyId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer JpaKeyDictionaryDao.getOrSaveKeyId(String)"})
  public void testGetOrSaveKeyId_givenKeyDictionaryRepositoryFindByIdReturnEmpty_thenCallsSave() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);
    when(keyDictionaryRepository.save(Mockito.<KeyDictionaryEntry>any())).thenReturn(keyDictionaryEntry);
    Optional<KeyDictionaryEntry> emptyResult = Optional.empty();
    when(keyDictionaryRepository.findById(Mockito.<KeyDictionaryCompositeKey>any())).thenReturn(emptyResult);

    // Act
    Integer actualOrSaveKeyId = jpaKeyDictionaryDao.getOrSaveKeyId("Str Key");

    // Assert
    verify(keyDictionaryRepository, atLeast(1)).findById(isA(KeyDictionaryCompositeKey.class));
    verify(keyDictionaryRepository).save(isA(KeyDictionaryEntry.class));
    assertEquals(1, actualOrSaveKeyId.intValue());
  }

  /**
   * Test {@link JpaKeyDictionaryDao#getOrSaveKeyId(String)}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaKeyDictionaryDao#getOrSaveKeyId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer JpaKeyDictionaryDao.getOrSaveKeyId(String)"})
  public void testGetOrSaveKeyId_thenReturnIntValueIsOne() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);
    Optional<KeyDictionaryEntry> ofResult = Optional.of(keyDictionaryEntry);
    when(keyDictionaryRepository.findById(Mockito.<KeyDictionaryCompositeKey>any())).thenReturn(ofResult);

    // Act
    Integer actualOrSaveKeyId = jpaKeyDictionaryDao.getOrSaveKeyId("Str Key");

    // Assert
    verify(keyDictionaryRepository).findById(isA(KeyDictionaryCompositeKey.class));
    assertEquals(1, actualOrSaveKeyId.intValue());
  }

  /**
   * Test {@link JpaKeyDictionaryDao#getOrSaveKeyId(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaKeyDictionaryDao#getOrSaveKeyId(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer JpaKeyDictionaryDao.getOrSaveKeyId(String)"})
  public void testGetOrSaveKeyId_thenThrowRuntimeException() {
    // Arrange
    when(keyDictionaryRepository.findById(Mockito.<KeyDictionaryCompositeKey>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaKeyDictionaryDao.getOrSaveKeyId("Str Key"));
    verify(keyDictionaryRepository).findById(isA(KeyDictionaryCompositeKey.class));
  }

  /**
   * Test {@link JpaKeyDictionaryDao#getKey(Integer)}.
   * <ul>
   *   <li>Given {@link KeyDictionaryEntry} (default constructor) Key is {@code Key}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaKeyDictionaryDao#getKey(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JpaKeyDictionaryDao.getKey(Integer)"})
  public void testGetKey_givenKeyDictionaryEntryKeyIsKey_thenReturnKey() {
    // Arrange
    KeyDictionaryEntry keyDictionaryEntry = new KeyDictionaryEntry();
    keyDictionaryEntry.setKey("Key");
    keyDictionaryEntry.setKeyId(1);
    Optional<KeyDictionaryEntry> ofResult = Optional.of(keyDictionaryEntry);
    when(keyDictionaryRepository.findByKeyId(anyInt())).thenReturn(ofResult);

    // Act
    String actualKey = jpaKeyDictionaryDao.getKey(1);

    // Assert
    verify(keyDictionaryRepository).findByKeyId(eq(1));
    assertEquals("Key", actualKey);
  }

  /**
   * Test {@link JpaKeyDictionaryDao#getKey(Integer)}.
   * <ul>
   *   <li>Then throw {@link DataIntegrityViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaKeyDictionaryDao#getKey(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JpaKeyDictionaryDao.getKey(Integer)"})
  public void testGetKey_thenThrowDataIntegrityViolationException() {
    // Arrange
    when(keyDictionaryRepository.findByKeyId(anyInt())).thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> jpaKeyDictionaryDao.getKey(1));
    verify(keyDictionaryRepository).findByKeyId(eq(1));
  }
}
