# 같은 코드인데 왜 100번째 요청이 더 빠를까?

JVM 워밍업과 JIT 컴파일을 운영 관점에서 설명하는 8부작 시리즈입니다.

## 실험 프로젝트

Java 21, Gradle Kotlin DSL과 Version Catalog를 사용합니다. `core`의 계산 코드를 Spring Boot와 JMH가 함께 호출합니다.

```bash
./gradlew clean build
./gradlew :app:bootRun
./scripts/request-sequence.sh
./gradlew :benchmarks:jmh
```

## 목차

| 회차 | 제목 | 상태 |
|---|---|---|
| 1 | [첫 요청이 느린 범인은 JIT 하나가 아니다](chapters/01-first-request-is-not-only-jit.md) | 초안 |
| 2 | [Java 코드는 처음에 어떻게 실행되는가](chapters/02-how-java-code-runs.md) | 개요 |
| 3 | [JIT는 어떤 코드를 컴파일할까](chapters/03-how-code-becomes-hot.md) | 개요 |
| 4 | [왜 한 번이 아니라 단계적으로 빨라질까](chapters/04-tiered-compilation.md) | 개요 |
| 5 | [JIT가 실제로 하는 최적화](chapters/05-jit-optimizations.md) | 개요 |
| 6 | [최적화된 코드가 다시 느려질 수도 있다](chapters/06-deoptimization.md) | 개요 |
| 7 | [워밍업을 어떻게 제대로 측정할까](chapters/07-measuring-warmup.md) | 개요 |
| 8 | [운영 환경에서는 워밍업을 어떻게 다룰까](chapters/08-warmup-in-production.md) | 개요 |

## 관리 방법

어느 컴퓨터에서든 저장소를 clone한 뒤 Markdown 파일을 수정하면 됩니다.

```bash
git clone https://github.com/qkrtkdwns3410/jvm-warmup-series.git
cd jvm-warmup-series
git pull
```

글을 수정한 뒤에는 다음 순서로 반영합니다.

```bash
git add .
git commit -m "docs: update chapter 1"
git push
```

## 문서 작성 규칙

- 한 파일에는 한 회차만 작성합니다.
- 제목 아래의 상태를 `개요`, `초안`, `검토 중`, `완료` 중 하나로 표시합니다.
- 기술 용어는 처음 등장할 때 한글과 영문을 함께 적습니다.
- 예제 수치는 실제 측정값인지 설명용 가상 수치인지 명시합니다.
- 새로운 회차나 제목을 바꾸면 README 목차도 함께 수정합니다.
