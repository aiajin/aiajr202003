package board.service;

// [답변 쓰기 요청 관련 정보를 저장]

// WritingRequest 의 요청정보 외에 답변을 등록할 부모 게시글의 idx 값 등을 포함
public class ReplyingRequest extends WritingRequest {
	
	private int parentBoard_idx;
	private int ref;
	private int step;
	private int low;	

	public int getParentBoard_idx() { return parentBoard_idx; }
	public void setParentBoard_idx(int parentBoard_idx) { this.parentBoard_idx = parentBoard_idx; }

	public int getRef() { return ref; }
	public void setRef(int ref) { this.ref = ref; }
	
	public int getStep() { return step; }
	public void setStep(int step) { this.step = step; }
	
	public int getLow() { return low; }
	public void setLow(int low) { this.low = low; }	
	
}
