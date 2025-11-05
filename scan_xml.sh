#!/usr/bin/env bash
set -euo pipefail

# Exclude noisy/build dirs
EXCLUDES=(-path "*/.git/*" -o -path "*/target/*" -o -path "*/node_modules/*" -o -path "*/build/*" -o -path "*/dist/*")

# Helper: search all .java files with a *literal* pattern (-F)
search_java_F () {
  local pat="$1"
  echo "----> $pat"
  find . -type f -name "*.java" \( ! \( "${EXCLUDES[@]}" \) \) -print0 \
    | xargs -0 grep -nIF -- "$pat" || true
}

# Helper: search all .java files with a *regex* pattern (-E), but keep it simple
search_java_E () {
  local pat="$1"
  echo "----> $pat"
  find . -type f -name "*.java" \( ! \( "${EXCLUDES[@]}" \) \) -print0 \
    | xargs -0 grep -nIE -- "$pat" || true
}

# Helper: search all files
search_all_E () {
  local pat="$1"
  echo "----> $pat"
  find . -type f \( ! \( "${EXCLUDES[@]}" \) \) -print0 \
    | xargs -0 grep -nIE -- "$pat" || true
}

echo "== A) Java classes referencing .xml resource files =="
# Keep these as simple *literal* substring checks:
search_java_F '.xml"'
search_java_F ".xml'"
search_java_F '.xml)'
search_java_F 'classpath:'
search_java_F 'classPath:'
search_java_F 'file:.xml'
# Also look for slash paths ending with .xml (regex but simple)
search_java_E '/[^"'\'' )]+\.xml'

echo
echo "== B) Spring XML configuration usage (@ImportResource, XML app contexts) =="
# These are simple and portable:
search_java_E '@ImportResource'
search_java_E 'ClassPathXmlApplicationContext'
search_java_E 'XmlBeanFactory'
search_java_E 'ApplicationContext[^"\047]*\.xml'
# Typical Spring XML filenames anywhere in repo:
search_all_E '(^|/)(applicationContext|spring|.*-context)\.xml$|["'\''.](applicationContext|spring|.*-context)\.xml["'\'')]'

echo
echo "== C) DOM/SAX/JAXB/Jackson-XML APIs in Java classes (parsing/serializing XML) =="
search_java_E 'javax\.xml'
search_java_E 'org\.w3c\.dom'
search_java_E 'org\.xml\.sax'
search_java_E 'javax\.xml\.parsers'
search_java_E 'DocumentBuilderFactory'
search_java_E 'SAXParser'
search_java_E 'TransformerFactory'
search_java_E 'JAXB|jakarta\.xml\.bind'
search_java_E 'com\.fasterxml\.jackson\.dataformat\.xml'

echo
echo "== D) Resource-loading calls that might point at XML files =="
# Keep these simple too; first look for XML in getResourceAsStream, then general loaders:
search_java_E 'getResourceAsStream\(".*\.xml"\)'
search_java_E 'ClassPathResource\('
search_java_E 'ResourceUtils\.get(File|URL)\('
search_java_E 'Files\.(readAllBytes|newInputStream)\('

echo
echo "== E) Any non-Java XML files in the repo (to eyeball) =="
find . -type f -name "*.xml" \( ! \( "${EXCLUDES[@]}" \) \) -print || true
