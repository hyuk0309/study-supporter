


# Study Supporter

## Intro
Study를 진행하면서 필요성을 느낀 기능을 직접 개발하는 프로젝트

## User Guid

1. Execute Server
```shell
# clone repo
git clone https://github.com/hyuk0309/study-supporter.git

# clean and build using gradle
gradle clean build

# execute (need java 17)
java -jar ./build/libs/study-supporter-0.0.1-SNAPSHOT.jar
```

2. Access Server Using Browser
http://localhost:8080/

**WARN : Data stored in embedded H2. So, If your server down, then your data gone too.**

## Feature

- Add Member
- Get Members
- Delete Member
- Choose Presenter
