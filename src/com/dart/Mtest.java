package com.dart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mtest {
	public static void main(String[] args) {
		Pattern pt = Pattern.compile("[\\,]");
		String sss = "36302,수시채용,휴메딕스,,20190215,20190415,http://www.humedix.com,http://recruit.huons.com/Recruit/careerDetail?announceType=&announceIdx=152&isOpen=0,http://www.work.go.kr/framework/filedownload/getImage.do?filePathName=KuBCC2IodBkj%2Frlv8XuRiguGtrHU3dxrLW5pirX9HNPD6Q%2FNa4vcidPFwpIEwGHZ7suWeZYPwv8GKFqD7PXO%2Fg%3D%3D,정규직,,,,,온라인 입사지원,,,,서류전형,,,,1차 면접실무진,,,,인적성검사 및 2차 면접경영진,,,,채용 검진,,,,최종 합격  입사,,,,,,,,기술지원부, Utility 및 생산 설비 유지보수,경력,학력무관, 전공  기계관련학과 전공자 우대  자격사항  기계 설비 관련 자격증 소지자 우대  기타  제약공장 유지보수 업무 경험자 우대 국가보훈대상자 및 복지카드 소유자 우대,2,,충북 제천시,경영지원본부, 전략기획 및 법무,경력,, 전공  상경계열 법학계열  기타  해당 업무경력 7년 이상 바이오제약 산업 경험자 컴퓨터활용 능력 우수자EXCEL PPT 등,1,,경기 안양시,마케팅팀, 필러 마케팅  리즈톡스 마케팅,경력,, 기타  총 경력 중 에스테틱 분야의 톡신 필러 경험 2년 이상 필수리즈톡스 마케팅 1명    에스테틱분야 비급여 분야에서의 경험 필수필러 마케팅 1명,2,,경기 안양시,에스테틱1사업부, 엘라비에 제약영업MR,경력신입,학력무관, 자격사항  경력 3년이상  기타  필러 미용성형기기 웰빙주사제 영업 경력,1,,경기 안양시,에스테틱2사업부, Filler 및 Toxin을 중심으로 한 Aesthetic 영업 부산대전,경력,,우대사항  자격사항  Filler와 Toxin 국내 영업 有 경험자 병역필 또는 면제자로 해외여행에 결격사유가 없어야 합니다  기타  국가보훈대상자 및 장애인 관련서류 제출시 과계 법령에 의거 우대 입사지원 서류 허위사실이 발견될 경우 채용 확정 이후라도 채용 취소 될수도 있습니다 근무지  강원충청영남호남제주,2,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,01,경영·사무·금융·보험,02,연구 및 공학기술,,,,,,,,,";
		String ddd = "36330,2019년 IT부문 경력사원 모집,현대오토에버,대기업,20190218,20190418,http://www.hyundai-autoever.com,http://recruit.hyundai-autoever.com/index.jsp,http://www.work.go.kr/framework/filedownload/getImage.do?filePathName=KuBCC2IodBkj%2Frlv8XuRiv8Yi2YJ1rUO9OBUCQvss%2F0gn3QjUEBQEGyMHrD521Kd7suWeZYPwv8GKFqD7PXO%2Fg%3D%3D,정규직,,,,,서류전형,,,,역량실무면접 온라인 인성검사 코딩테스트필요시 영어구술평가 필기실기평가 실시,,,,인성임원면접,,,,신체검사 후 최종합격,,,,기타,,면접일시는 서류전형 합격자에 한하여 개별통보 예정입니다,,,,,,,,,,IT_인프라 운영구축, 제철 공장 네트워크 인프라 운영,경력,, 네트워크 인프라 구축운영 경험  방화벽 IPS 구축운영 경험,,,충남 당진시,IT_인프라 운영구축, 부품 연구소 인프라서버 관리 및 운영,경력,, 서버스토리지백업시스템 운영 경험  가상화클라우드 시스템 운영 경험  Oracle Exatada 운영 경험,,,경기 용인시 기흥구,IT_시스템 개발운영, 부품 공장 MES 시스템 개발 및 운영,경력,, CNet 기반 개발 및 운영 경험  Spring Framework 기반 운영 경험  MES 시스템 운영 경험,,,충남 서산시,IT_시스템 개발운영, 부품 공장 MES 시스템 개발 및 운영,경력,, 제조업 MES 기획구축 경험  MS SQL DBMS 및 NT Server 운영 경험  CC 기반 MES 개발 경험  ASPNET 기반 WEB 개발 및 운영 경험,,,충남 천안시,IT_시스템 개발운영, 부품 연구소 PLM 시스템 개발 및 운영,경력,, 부품 개발 기술정보관리 등 RD 부분 시스템 개발 및 운영 경험  JAVA 기반 WEB 개발 및 운영 경험,,,경기 용인시 기흥구,IT_시스템 개발운영, SAP COTRFI,경력,, SAP COTRFI 구축운영 경험  ABAP 프로그램 개발 및 운영 경험,,,서울 종로구,IT_시스템 개발운영, SAP MMPMQMFCM각 모듈별 모집,경력,, 제조업 관련 MMPMQMFCM 모듈 구축운영 경험  제조업 관련 ABAP 및 기타 프로그램 개발 경험  �,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";
		Matcher mm = pt.matcher(sss);
		System.out.println(mm.toMatchResult());
		System.out.println(mm.regionEnd());
		System.out.println(sss.split(",").length);
		System.out.println(ddd.split(",").length);
		System.out.println("，".equals(","));
		System.out.println("/".equals("/"));
	}
}
