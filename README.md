#  💡 알고리즘 스터디 💡

SSAFY 9기 부울경 4반 2조 알고리즘 스터디 기록

<br>

## 🙋🏻‍♂️ Contributors
<table>
  <tr>
   <td align="center"><a href="https://github.com/kss4037"><img src="https://avatars.githubusercontent.com/u/49977437?v=4" width="120px;" alt=""/><br /><sub><b>권선근</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/ksy00826"><img src="https://avatars.githubusercontent.com/u/76732805?v=4" width="120px;" alt=""/><br /><sub><b>김승연</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/qjrm69"><img src="https://avatars.githubusercontent.com/u/38920667?v=4" width="120px;" alt=""/><br /><sub><b>이종윤</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/Harinee68"><img src="https://avatars.githubusercontent.com/u/62701446?v=4" width="120px;" alt=""/><br /><sub><b>이하린</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/jeunjeong"><img src="https://avatars.githubusercontent.com/u/123714739?v=4" width="120px;" alt=""/><br /><sub><b>조은정</b></sub></a><br /></td>
  </tr>
</table>
<br>

## 📌 Rule
각자 문제를 선정하여 매주 4~5문제를 풉니다.
* ❗❗ 문제풀이 마감 : 매주 토요일 23:59 까지
* ❕❕ 리뷰 마감 : 매주 일요일 23:59 까지
<br>

## 📌 Convention
###  1️⃣ Code Convention
각 코드 별 목적을 주석으로 작성합니다.
변수와 함수 이름 또한 역할을 알 수 있도록 간단한 주석을 덧붙입니다.

<br>

### 2️⃣ Project Convention

각 멤버별 프로젝트 구조는 다음과 같습니다
**이름/week번호/플랫폼_문제번호_레벨_문제이름/...**

    김싸피/week15/BOJ_1051_S3_숫자정사각형/...

<br>

### 3️⃣ Commit Convention
한번에 모든 파일을 add하지 않고 type별로 분리하여 commit 합니다.

    docs : README.md 등 문서 작성 및 수정
    code : 코드 작성
    fix : 코드 수정
    add : 기존에 푼 문제에 대한 추가
    remove : 코드 및 문서 삭제
    merge : pr(pull request)을 통해 자신의 repo에서 원본 repo로 merge하기
  <br>

적용 예시 ::
1. BOJ의 1051번 숫자 정사각형 (silver3) 문제를 풀었다면
해당 코드를 하나의 commit으로 분리합니다.  
이 때의 commit message는 다음과 같이 통일합니다
		
		 git commit -m "code : BOJ 1051 S3 숫자정사각형"

	해당 코드를 수정할 때의 commit message는 다음과 같이 통일합니다.
		
		 git commit -m "fix : BOJ 1051 S3 숫자정사각형"

2.  코드에 대한 설명을 작성하고
해당 문서를 하나의 commit으로 분리합니다.  
이 때의 commit message는 다음과 같습니다.
		
		 git commit -m "docs : BOJ 1051 S3 숫자정사각형"

3. main README.md 파일을 수정할 때의 commit message는 다음과 같습니다.
		
		 git commit -m "docs : main README update"

5. 파일을 삭제할 경우 commit message는 다음과 같습니다
		
		 git commit -m "remove : 삭제파일"
		
<br>

### 4️⃣ Review Convention
1. Pull Request의 제목은 다음과 같이 통일합니다.
**이름 : 문제플랫폼 문제번호 문제등급 문제제목** 
		
		 김싸피 : BOJ 1051 S3 숫자정사각형
		
2. Pull Request의 comment에는 본인이 작성한 README.md의 내용을 추가합니다. 

3. 문제에 해당하는 유형을 선택하여 PR에 label을 attach하고,   
 자신의 PR의 assignee에 자신을 추가 후 문제풀이 week에 해당하는 Milestones을 선택합니다.

4. 기존에 PR을 작성 후 새로운 문제를 풀었을 경우, 새로운 문제에 대한 commit을 하기 전 다음 과정을 수행합니다.

	- ❓ 코드리뷰가 완료 되었을 경우  
		자신의 PR에서 merge 버튼을 눌러 merge 합니다. 
		
	- ❓ 리뷰 완료 전 새로운 문제를 풀 경우
		1. 자신의 local에서 새로 푼 문제에 대한 branch를 생성합니다.  
		이 때 branch의 이름을 **문제플랫폼-문제번호**과 같이 생성하는 것을 권장합니다.
		
			    boj-1051
		
		2. 새로운 문제에 대한 code와 README.md에 대한 commit을 추가 후 push합니다.   
		이 때의 commit message는 2️⃣ Commit Convention에서 언급한 규칙에 맞게 설정합니다.
		3. 이 때 반드시 (a)에서 생성한 branch로 push 되는지 확인합니다.
		4. 본인 계정의 fork된 repo에서 Pull Request을 작성할 때,   
		코드가 push된 브랜치(a에서 생성한 jihong/boj-1051)에서   
		organization repo의 main 브랜치로 Pull Request를 보냅니다.


<br><br>

## 📌 Solved Problems
### 🚩 week 1
| Type | 문제 | 제목 | 유형 | rank |
| -- |--| -- |--|--|
| BOJ | 10828 | [스택](https://www.acmicpc.net/problem/10828) | 자료구조 | silver4 |
| BOJ | 1620 | [나는야 포켓몬 마스터 이다솜](https://www.acmicpc.net/problem/1620) | 자료구조2 | silver4 |
| BOJ | 6416 | [트리](https://www.acmicpc.net/problem/6416) | 트리 | ? |
| BOJ | 5618 | [공약수](https://www.acmicpc.net/problem/5618) | 수학 | Bronze2 |

### 🚩 week 2
| Type | 문제 | 제목 | 유형 | rank |
| -- |--| -- |--|--|
| BOJ | 17626 | [Four Squares](https://www.acmicpc.net/problem/17626) | 동적계획법1 | silver3 |
| BOJ | 9084 | [동전](https://www.acmicpc.net/problem/9084) | 동적계획법2 | gold5 |
| BOJ | 21921 | [블로그](https://www.acmicpc.net/problem/21921) | 투 포인터 | silver3 |
| BOJ | 1913 | [달팽이](https://www.acmicpc.net/problem/1913) | 구현 | silver3 |

### 🚩 week 3
| Type | 문제 | 제목 | 유형 | rank |
| -- |--| -- |--|--|
| BOJ | 21608 | [상어 초등학교](https://www.acmicpc.net/problem/21608) | 구현 | gold5 |
| BOJ | 2606 | [바이러스](https://www.acmicpc.net/problem/2606) | 그래프 탐색 | silver3 |
| BOJ | 16234 | [인구 이동](https://www.acmicpc.net/problem/16234) | 시뮬레이션 | gold5 |
| BOJ | 2512 | [예산](https://www.acmicpc.net/problem/2512) | 이분탐색 | silver3 |

### 🚩 week 4
| Type | 문제 | 제목 | 유형 | rank |
| -- |--| -- |--|--|
| BOJ | 15651 | [N과 M (3)](https://www.acmicpc.net/problem/15651) | 백트랙킹 | sliver3 |
| BOJ | 2447 | [별 찍기 - 10](https://www.acmicpc.net/problem/2447) | 분할정복 | gold5 |
| BOJ | 21318 | [피아노 체조](https://www.acmicpc.net/problem/21318) | 누적합 | sliver1 |
| BOJ | 9342 | [염색체](https://www.acmicpc.net/problem/9342) | 문자열 | silver3 |

### 🚩 week 5 
-> A형 역량 평가 대비 SWEA 문제 풀이

### 🚩 week 6
| Type | 문제 | 제목 | 유형 | rank |
| -- |--| -- |--|--|
| BOJ | 18352 | [특정 거리의 도시 찾기](https://www.acmicpc.net/problem/18352) | 최단거리 | sliver2 |
| BOJ | 14567 | [선수과목](https://www.acmicpc.net/problem/14567) | 위상정렬 | gold5 |
| BOJ | 1717 | [집합의 표현](https://www.acmicpc.net/problem/1717) | Disjoint Set  | gold5 |
| BOJ | 1197 | [최소 스패닝 트리](https://www.acmicpc.net/problem/1197) | 최소 스패닝 트리 | gold4 |

### 🚩 week 6
| Type | 문제 | 제목 | 유형 | rank |
| -- |--| -- |--|--|
| BOJ | 14425 | [문자열 집합](https://www.acmicpc.net/problem/14425) | Trie | sliver3 |
| BOJ | 15681 | [트리와 쿼리](https://www.acmicpc.net/problem/15681) | 트리 DP | gold 5 |
| BOJ | 1935 | [후위 표기식 2](https://www.acmicpc.net/problem/1935) | 자료구조 | silver3 |
| BOJ | 7662 | [이중 우선순위 큐](https://www.acmicpc.net/problem/7662) | 자료구조 2 | gold4 |

