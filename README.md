# Bank Faker Russian

Java библиотека для генерации российских банковских и налоговых кодов: ИНН, ОГРН, БИК, КПП, ОКПО, СНИЛС, ОКАТО, корреспондентских и расчётных счетов, кадастровых номеров.

[![Maven Central](https://img.shields.io/maven-central/v/com.github.fakerussian/bank-faker-russian.svg)](https://search.maven.org/artifact/com.github.fakerussian/bank-faker-russian)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Возможности

* **БИК** (Банковский идентификационный код)
* **ИНН** (Идентификационный номер налогоплательщика) 
* **КПП** (Код причины постановки на учёт)
* **ОГРН** (Основной государственный регистрационный номер)
* **ОКПО** (Общероссийский классификатор предприятий и организаций)
* **СНИЛС** (Страховой номер индивидуального лицевого счёта)
* **ОКАТО** (Общероссийский классификатор объектов административно-территориального деления)
* **Корреспондентский счёт**
* **Расчётный счёт**
* **Кадастровый номер**

## Установка

### Maven

```xml
<dependency>
    <groupId>thread.qa.bankfaker</groupId>
    <artifactId>bank-faker-russian</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```gradle
implementation 'thread.qa.bankfaker:bank-faker-russian:1.0.0'
```

## Использование

### Базовое использование

```java
import thread.qa.bankfaker.FakerRussian;

FakerRussian faker = new FakerRussian();

// Генерация случайных значений
String inn = faker.inn();           // "7825489562"
String bik = faker.bik();           // "044525225"
String ogrn = faker.ogrn();         // "1027739244741"
String kpp = faker.kpp();           // "784301001"
String okpo = faker.okpo();         // "12345678"
String snils = faker.snils();       // "11223344595"
String okato = faker.okato();       // "45286585000"
```

### Использование с параметрами

#### БИК

```java
import thread.qa.bankfaker.generators.BikOptions;

// БИК для конкретного региона ОКАТО
String bik = faker.bik(new BikOptions("78")); // "047825225"

// БИК с фиксированной последовательностью
String bik = faker.bik(new BikOptions(12345L)); // всегда одинаковый результат
```

#### ИНН

```java
import thread.qa.bankfaker.generators.InnOptions;
import thread.qa.bankfaker.generators.InnOptions.Kind;

// ИНН физического лица (12 цифр)
String individualInn = faker.inn(new InnOptions(Kind.INDIVIDUAL));

// ИНН юридического лица (10 цифр)
String legalInn = faker.inn(new InnOptions(Kind.LEGAL));

// ИНН для конкретного региона
String regionInn = faker.inn(new InnOptions("78"));

// Комбинированные параметры
InnOptions options = new InnOptions(12345L, "78", Kind.LEGAL);
String inn = faker.inn(options);
```

#### ОГРН

```java
import thread.qa.bankfaker.generators.OgrnOptions;
import thread.qa.bankfaker.generators.OgrnOptions.Kind;

// ОГРН юридического лица (13 цифр)
String legalOgrn = faker.ogrn(new OgrnOptions(Kind.LEGAL));

// ОГРНИП индивидуального предпринимателя (15 цифр)
String individualOgrn = faker.ogrn(new OgrnOptions(Kind.INDIVIDUAL));

// ОГРН для конкретного региона
String regionOgrn = faker.ogrn(new OgrnOptions("78"));
```

#### Корреспондентский счёт

```java
import thread.qa.bankfaker.generators.CorrespondentAccountOptions;

// Корреспондентский счёт для конкретного БИК
String account = faker.correspondentAccount(new CorrespondentAccountOptions("044525225"));
```

#### Расчётный счёт

```java
import thread.qa.bankfaker.generators.SettlementAccountOptions;

// Расчётный счёт с конкретным ОКВ
String account = faker.settlementAccount(new SettlementAccountOptions("810"));
```

#### ОКАТО

```java
import thread.qa.bankfaker.generators.OkatoOptions;

// ОКАТО конкретной длины
String okato3 = faker.okato(new OkatoOptions(3));   // 3 цифры
String okato6 = faker.okato(new OkatoOptions(6));   // 6 цифр
String okato9 = faker.okato(new OkatoOptions(9));   // 9 цифр

// ОКАТО для конкретного региона
String regionOkato = faker.okato(new OkatoOptions("78"));
```

#### Кадастровый номер

```java
import thread.qa.bankfaker.generators.CadastralNumberOptions;

// Кадастровый номер с конкретными параметрами
CadastralNumberOptions options = new CadastralNumberOptions(61, 16, "8960136");
String cadastral = faker.cadastralNumber(options); // "61:16:8960136:44567"

// Общероссийский кадастровый округ
CadastralNumberOptions commonOptions = new CadastralNumberOptions(0, 0, "0");
String commonCadastral = faker.cadastralNumber(commonOptions); // "0:0:0:1768"
```

### Детерминированная генерация

Все генераторы поддерживают детерминированную генерацию через параметр `sequenceNumber`:

```java
// Одинаковый sequence number всегда даёт одинаковый результат
Long sequence = 12345L;
String inn1 = faker.inn(new InnOptions(sequence));
String inn2 = faker.inn(new InnOptions(sequence));
// inn1.equals(inn2) == true
```

## Валидация

Все генерируемые значения соответствуют официальным алгоритмам расчёта контрольных сумм и форматам российских кодов.

## Лицензия

MIT License. См. [LICENSE](LICENSE) для подробностей.

## Вклад в проект

Приветствуются pull request'ы и issue. Для крупных изменений сначала откройте issue для обсуждения.

## Связь

- GitHub: [https://github.com/penolegrus/bank-faker](https://github.com/penolegrus/bank-faker)
- Issues: [https://github.com/penolegrus/bank-faker/issues](https://github.com/penolegrus/bank-faker/issues)