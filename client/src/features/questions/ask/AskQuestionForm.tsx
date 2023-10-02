import { Button, Input, TextArea } from '@components';

export const AskQuestionForm = () => {
  const handleSubmit = () => {};

  return (
    <>
      <div className="">
        {/* Main Container */}
        <div className="mx-[140px] min-h-screen flex">
          <div className="box flex flex-col gap-8 w-full justify-center">
            <div className="title">
              <h1 className="text-[22px] font-bold text-brand-50">
                Ask Your Question Now
              </h1>
            </div>
            {/* Input(s) container*/}
            <div className="flex flex-col gap-5">
              <Input id="title" label="Question Title" />
              <TextArea />
            </div>
            {/* Button(s) container*/}
            <div className="flex items-center gap-4">
              <Button label="Submit" variant="solid" size="md" />
            </div>
          </div>
        </div>
        {/* Sub-container */}
      </div>
    </>
  );
};
