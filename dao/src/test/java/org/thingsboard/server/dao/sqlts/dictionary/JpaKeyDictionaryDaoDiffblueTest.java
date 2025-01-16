package org.thingsboard.server.dao.sqlts.dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryCompositeKey;
import org.thingsboard.server.dao.model.sqlts.dictionary.KeyDictionaryEntry;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaKeyDictionaryDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
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
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaKeyDictionaryDao#getOrSaveKeyId(String)}
   */
  @Test
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
   * Test {@link JpaKeyDictionaryDao#getKey(Integer)}.
   * <ul>
   *   <li>Given {@link KeyDictionaryEntry} (default constructor) Key is
   * {@code Key}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaKeyDictionaryDao#getKey(Integer)}
   */
  @Test
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
  public void testGetKey_thenThrowDataIntegrityViolationException() {
    // Arrange
    when(keyDictionaryRepository.findByKeyId(anyInt())).thenThrow(new DataIntegrityViolationException("Msg"));

    // Act and Assert
    assertThrows(DataIntegrityViolationException.class, () -> jpaKeyDictionaryDao.getKey(1));
    verify(keyDictionaryRepository).findByKeyId(eq(1));
  }
}
