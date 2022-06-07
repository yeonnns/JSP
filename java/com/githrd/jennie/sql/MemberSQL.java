package com.githrd.jennie.sql;

public class MemberSQL {
	public final int SEL_LOGIN_CNT 		= 1001;
	public final int SEL_MEMBER_INFO 	= 1002;
	public final int SEL_AVT_INFO 		= 1003;
	public final int SEL_ALL_AVT 		= 1004;
	public final int SEL_ID_CNT 		= 1005;
	public final int SEL_MEMBER_LIST	= 1006;
	public final int SEL_MNO_INFO		= 1007;
	
	public final int DEL_MEMBER 		= 2001;
	public final int EDIT_MEMBER 		= 2002;

	public final int ADD_MEMBER 		= 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			buff.append("	AND pw = ? ");
			break;
		case SEL_ID_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	id = ? ");
			break;
		case SEL_AVT_INFO:
			buff.append("SELECT ");
			buff.append("	ano, savename, dir, gen ");
			buff.append("FROM ");
			buff.append("	avatar ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND ano = ? ");
			break;
		case SEL_ALL_AVT:
			buff.append("SELECT ");
			buff.append("	ano, savename, gen ");
			buff.append("FROM ");
			buff.append("	avatar ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND gen != 'N' ");
			break;
		case SEL_MEMBER_INFO:
			buff.append("SELECT ");
			buff.append("	mno, name, id, mail, tel, m.gen, joindate, ano, savename ");
			buff.append("FROM ");
			buff.append("	member m, avatar ");
			buff.append("WHERE ");
			buff.append("	m.isshow = 'Y' ");
			buff.append("	AND avt = ano ");
			buff.append("	AND id = ? ");
			break;
		case SEL_MNO_INFO:
			buff.append("SELECT ");
			buff.append("	mno, name, id, mail, tel, m.gen, joindate, ano, savename ");
			buff.append("FROM ");
			buff.append("	member m, avatar ");
			buff.append("WHERE ");
			buff.append("	m.isshow = 'Y' ");
			buff.append("	AND avt = ano ");
			buff.append("	AND mno = ? ");
			break;
		case SEL_MEMBER_LIST:
			buff.append("SELECT ");
			buff.append("	mno, name ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case DEL_MEMBER:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND mno = ? ");
			break;
		case EDIT_MEMBER:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	### ");
			/*
				비밀번호를 수정하는 경우
					pw = ?
				메일을 수정하는 경우
					mail = ?
				tel
					tel = ?
				avatar
					avt = ?
					
				수정되는 가지수에 따라서
				질의명령의 set 절이 달라질 수 있다.
				이렇게 동적질의를 사용해야 할 경우는
				바뀌는 부분을 특수문자로 표시를 해두고
				데이터에 따라서 특수문자 대신 채워주면 된다.
			 */
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND mno = ? ");
			break;
		case ADD_MEMBER:
			buff.append("INSERT INTO ");
			buff.append("	member(mno, name, id, pw, mail, tel, avt, gen) ");
			buff.append("VALUES( ");
			buff.append("		(SELECT NVL(MAX(mno) + 1, 1001) FROM member), ");
			buff.append("		?, ?, ?, ?, ?, ?, ? ");
			buff.append(")");
			break;
		}
		return buff.toString();
	}
}